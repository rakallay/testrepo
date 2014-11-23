package com.richard;

import java.lang.Comparable;
import java.util.Arrays;

public class QuickSorter<T extends Comparable<T>>
{
    private final T[] items;

    public QuickSorter(T[] items)
    {
	this.items = items;
    }

    public void sort()
    {
	if (items == null)
	    throw new IllegalArgumentException("items to sort cannot be null");
	
	if (items.length == 0)
	    return;
	
	quicksort(0, items.length - 1);

    }

    private void quicksort(int left, int right)
    {
	if (left < right)
	{
	    int q = partition(left, right);
	    System.out.println("left: " + left + ", right: " + right + ", q: " + q + " items" + Arrays.toString(items));
	    quicksort(left, q -1);
	    quicksort(q + 1, right);
	}
    }

    private int partition(int left, int right)
    {
	T pivotElement = items[right];
	int i = left - 1;
	for (int j = left; j <= (right - 1); j++)
	{
	    if (items[j].compareTo(pivotElement) <= 0)
	    {
		i++;
		swapItems(i, j);
	    }
	}
	swapItems(i + 1, right);
	return i + 1;
    }

    private void swapItems(int idx1, int idx2)
    {
	T tempItem = items[idx1];
	items[idx1] = items[idx2];
	items[idx2] = tempItem;
    }

}
