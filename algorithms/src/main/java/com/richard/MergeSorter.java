package com.richard;

public class MergeSorter<T extends Comparable<T>>
{
    private final T[] items;

    public MergeSorter(T[] items)
    {
	this.items = items;
    }

    public void sort()
    {
	T[] sortedItems = mergesort(0, items.length - 1);
	for(int i = 0; i < sortedItems.length; i++)
	    items[i] = sortedItems[i];
    }

    private T[] mergesort(int left, int right)
    {
	if (left == right)
	{
	    return new T[] {items[left]};
	}
	if (left <= right)
	{
	    int mid = (left + right) / 2;
	    T[] leftSorted = mergesort(left, mid);
	    T[] rightSorted = mergesort(mid + 1, right);
	    return merge(leftSorted, rightSorted);
	}
    }

    private T[] merge(T[] leftItems, T[] rightItems)
    {
	if (leftItems == null)
	    throw new IllegalArgumentException("leftItems cannot be null");
	if (rightItems == null)
	    throw new IllegalArgumentException("rightItems cannot be null");

	if (leftItems.length == 0)
	    return rightItems;
	if (rightItems.length == 0)
	    return leftItems;
	
	T[] merged = new T[leftItems.length + rightItems.length];
	int l = 0;
	int r = 0;
	int m = 0;
	while(l < leftItems.length && r < rightItems.length)
	{
	    if (leftItems[l] < rightItems[r])
	    {
		l++;
		merged[m] = leftItems[l];
		continue;
	    }

	    if (rightItems[r] <= leftItems[l])
	    {
		r++;
		merged[m] = rightItems[r];
		continue;
	    }
	}

	if (r < rightItems.length)
	{
	    for (int i = r; i < rightItems.length; i++)
		merged[i] = rightItems[i];
	}
	if (l < leftItems.length)
	{
	    for (int i = l; i < leftItems.length; i++)
		merged[i] = leftItems[i];
	}
	return merged;
    }
}
