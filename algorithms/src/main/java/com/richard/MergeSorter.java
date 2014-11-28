package com.richard;

public class MergeSorter
{
    private final Integer[] items;

    public MergeSorter(Integer[] items)
    {
	this.items = items;
    }

    public void sort()
    {
	Integer[] sortedItems = mergesort(0, items.length - 1);
	for(int i = 0; i < sortedItems.length; i++)
	    items[i] = sortedItems[i];
    }

    private Integer[] mergesort(int left, int right)
    {
	if (left < right)
	{
	    int mid = (left + right) / 2;
	    Integer[] leftSorted = mergesort(left, mid);
	    Integer[] rightSorted = mergesort(mid + 1, right);
	    return merge(leftSorted, rightSorted);
	}
	return new Integer[] {items[left]};
    }

    private Integer[] merge(Integer[] leftItems, Integer[] rightItems)
    {
	if (leftItems == null)
	    throw new IllegalArgumentException("leftItems cannot be null");
	if (rightItems == null)
	    throw new IllegalArgumentException("rightItems cannot be null");

	if (leftItems.length == 0)
	    return rightItems;
	if (rightItems.length == 0)
	    return leftItems;
	
	Integer[] merged = new Integer[leftItems.length + rightItems.length];
	int l = 0;
	int r = 0;
	int m = 0;
	while(l < leftItems.length && r < rightItems.length)
	{
	    if (leftItems[l] < rightItems[r])
	    {
		merged[m] = leftItems[l];
		l++;
		m++;
		continue;
	    }

	    if (rightItems[r] <= leftItems[l])
	    {
		merged[m] = rightItems[r];
		r++;
		m++;
		continue;
	    }
	}

	if (r < rightItems.length)
	{
	    for (int i = r; i < rightItems.length; i++)
	    {
		merged[m] = rightItems[i];
		m++;
	    }
	}
	if (l < leftItems.length)
	{
	    for (int i = l; i < leftItems.length; i++)
	    {
		merged[m] = leftItems[i];
		m++;
	    }
	}
	return merged;
    }
}
