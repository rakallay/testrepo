package com.richard;

public class MergeSorter<T extends Comparable>
{
    private final T[] items;

    public MergeSorter(T[] items)
    {
	this.items = items;
    }

    @SuppressWarnings("unchecked")
    public void sort()
    {
	Object[] sortedItems = mergesort(0, items.length - 1);
	for(int i = 0; i < sortedItems.length; i++)
	    items[i] = (T)sortedItems[i];
    }

    private Object[] mergesort(int left, int right)
    {
	if (left < right)
	{
	    int mid = (left + right) / 2;
	    Object[] leftSorted = mergesort(left, mid);
	    Object[] rightSorted = mergesort(mid + 1, right);
	    return merge(leftSorted, rightSorted);
	}
	return (Object[]) (new Object[]{items[left]});
    }

    @SuppressWarnings("unchecked")
    private Object[] merge(Object[] leftItems, Object[] rightItems)
    {
	if (leftItems == null)
	    throw new IllegalArgumentException("leftItems cannot be null");
	if (rightItems == null)
	    throw new IllegalArgumentException("rightItems cannot be null");

	if (leftItems.length == 0)
	    return rightItems;
	if (rightItems.length == 0)
	    return leftItems;
	
	Object[] merged = new Object[leftItems.length + rightItems.length];
	int l = 0;
	int r = 0;
	int m = 0;
	while(l < leftItems.length && r < rightItems.length)
	{
	    @SuppressWarnings ("unchecked") T leftElement = (T)leftItems[l];
	    @SuppressWarnings ("unchecked") T rightElement = (T)rightItems[r];
	    if (leftElement.compareTo(rightElement) < 0)
	    {
		merged[m] = leftItems[l];
		l++;
		m++;
		continue;
	    }

	    if (rightElement.compareTo(leftElement) <= 0)
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
