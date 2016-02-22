package com.richard;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class QuickSorter<T extends Comparable<T>>
{
    private final T[] items;

    public interface AlgorithmReplayer
    {
	public void replay();
    }
    
    public interface Partition<T extends Comparable<T>> extends AlgorithmReplayer
    {
	public QuickSort[] calculateQuickSorts();
    }

    public interface QuickSort<T extends Comparable<T>> extends AlgorithmReplayer
    {
	public void sort();
    }

    public static class PartitionImpl<T extends Comparable<T>> implements Partition<T>
    {
	private final T[] items;
	private final int leftIdx;
	private final int rightIdx;
	private final List<PartitionState> stateTracker;

	public PartitionImpl(T[] items, int leftIdx, int rightIdx)
	{
	    this.items = items;
	    this.leftIdx = leftIdx;
	    this.rightIdx = rightIdx;
	    this.stateTracker = new ArrayList<PartitionState>();
	}
	
	public QuickSort[] calculateQuickSorts()
	{
	    if (leftIdx >= rightIdx)
	    {
		return new QuickSortImpl[0];
	    }

	    T pivotElement = items[rightIdx];
	    int partitionIdx = leftIdx - 1;
	    stateTracker.add(new PartitionState(pivotElement, partitionIdx, 0, Arrays.copyOf(items, items.length), leftIdx, rightIdx));

	    for (int j = leftIdx; j < rightIdx; j++)
	    {

		stateTracker.add(new PartitionState(pivotElement, partitionIdx, j, Arrays.copyOf(items, items.length), leftIdx, rightIdx));

		if (items[j].compareTo(pivotElement) <= 0)
		{
		    partitionIdx++;
		    stateTracker.add(new PartitionState(pivotElement, partitionIdx, j, Arrays.copyOf(items, items.length), leftIdx, rightIdx));
		    swapItems(partitionIdx, j);
		    stateTracker.add(new PartitionState(pivotElement, partitionIdx, j, Arrays.copyOf(items, items.length), leftIdx, rightIdx));
		}
	    }
	    stateTracker.add(new PartitionState(pivotElement, partitionIdx, rightIdx, Arrays.copyOf(items, items.length), leftIdx, rightIdx));
	    partitionIdx++;
	    stateTracker.add(new PartitionState(pivotElement, partitionIdx, rightIdx, Arrays.copyOf(items, items.length), leftIdx, rightIdx));
	    swapItems(partitionIdx, rightIdx);
	    stateTracker.add(new PartitionState(pivotElement, partitionIdx, rightIdx, Arrays.copyOf(items, items.length), leftIdx, rightIdx));
	    
	    QuickSort[] sorters = new QuickSort[2];
	    sorters[0] = new QuickSortImpl(items, new PartitionImpl(items, leftIdx, partitionIdx - 1));
	    sorters[1] = new QuickSortImpl(items, new PartitionImpl(items, partitionIdx + 1, rightIdx));

	    return sorters;
	}

	private void swapItems(int idx1, int idx2)
	{
	    T tempItem = items[idx1];
	    items[idx1] = items[idx2];
	    items[idx2] = tempItem;
	}

	public void replay()
	{
	    for (PartitionState state : stateTracker)
	    {
		state.printState();
	    }
	}
    }

    public static class PartitionState<T>
    {
	private final T pivotElement;
	private final int partitionIdx;
	private final int j;
	private final T[] itemsSnapshot;
	private final int leftIdx;
	private final int rightIdx;
	
	public PartitionState(T pivotElement, int partitionIdx, int j, T[] itemsSnapshot, int leftIdx, int rightIdx)
	{
	    this.pivotElement = pivotElement;
	    this.partitionIdx = partitionIdx;
	    this.j = j;
	    this.itemsSnapshot = itemsSnapshot;
	    this.leftIdx = leftIdx;
	    this.rightIdx = rightIdx;
	}

	public void printState()
	{
	    System.out.println("PARTITION STATE");
	    System.out.println("pivotElement: " + pivotElement);
	    System.out.println("partitionIdx: " + partitionIdx);
	    System.out.println("j: " + j);
	    System.out.println("itemsSnapshot: " + Arrays.toString(Arrays.copyOfRange(itemsSnapshot, leftIdx, rightIdx + 1)));
	    System.out.println("END PARTITION STATE");
	}
    }

    public static class QuickSortImpl<T extends Comparable<T>> implements QuickSort<T>
    {
	private final T[] items;
	private final Partition partition;

	private List<QuickSort> childSorters;

	public QuickSortImpl(T[] items, Partition partition)
	{
	    this.items = items;
	    this.partition = partition;
	    this.childSorters = new ArrayList<QuickSort>();
	}

	public void sort()
	{
	    QuickSort[] sorters = partition.calculateQuickSorts();
	    for (QuickSort sorter : sorters)
	    {
		childSorters.add(sorter);
		sorter.sort();
	    }
	}

	public void replay()
	{
	    partition.replay();
	    for (QuickSort sorter : childSorters)
	    {
		sorter.replay();
	    }
	}
    }


    /*private static class QuickSortState
    {
	private final int leftIdx;
	private final int rightIdx;
	private final int partitionIdx;
	private final Partition partition;

	public QuickSortState(int leftIdx, int rightIdx)
	{
	    this.leftIdx = leftIdx;
	    this.rightIdx = rightIdx;
	    this.partition = partition;
	}

	public QuickSortState(int leftIdx, int rightIdx, Partition partition)
	{
	    this.leftIdx = leftIdx;
	    this.rightIdx = rightIdx;
	    this.partition = partition;
	}
    }

    private static class Partition
    {
	
    }*/

    public QuickSorter(T[] items)
    {
    	this.items = items;;
    }

    public void sort()
    {
    	if (items == null)
    	    throw new IllegalArgumentException("items to sort cannot be null");
    	
    	if (items.length == 0)
    	    return;

	System.out.println("Items before: " + Arrays.toString(items));
    	
	QuickSortImpl<T> sorter = new QuickSortImpl<T>(items, new PartitionImpl<T>(items, 0, items.length - 1));
	sorter.sort();	
	System.out.println("Items after: " + Arrays.toString(items));
	sorter.replay();
//    	quicksort(0, items.length - 1);
    }

    private static int quicksortCount = 0;
    private void quicksort(int leftIdx, int rightIdx)
    {
	quicksortCount++;
	int localCount = quicksortCount;
	T[] quicksortItems = Arrays.copyOfRange(items, leftIdx, rightIdx + 1);	
	System.out.println(">>>>quicksort#" + localCount + ": leftIdx= " + leftIdx + ", rightIdx= " + rightIdx + ", quicksortItems: " + Arrays.toString(quicksortItems));

	//QuickSortState qState = new QuickSortState(leftIdx, rightIdx);
    	if (leftIdx < rightIdx)
    	{
    	    int partitionIdx = partition(leftIdx, rightIdx);
	    System.out.println("quicksort#" + localCount + ": partitionIdx= " + partitionIdx);  
	    quicksort(leftIdx, partitionIdx - 1);
    	    quicksort(partitionIdx + 1, rightIdx);
    	}
	System.out.println("<<<<quicksort#" + localCount);
    }

    private static int partitionCount = 0;
    private int partition(int leftIdx, int rightIdx)
    {
	partitionCount++;
	int localCount = partitionCount;
	System.out.println(">>>>partition#" + localCount + ": leftIdx= " + leftIdx + ", rightIdx= " + rightIdx); 
    	T pivotElement = items[rightIdx];
    	int partitionIdx = leftIdx - 1;
	System.out.println("partition#" + localCount + ": partitionIDx= " + partitionIdx + ", pivotElement=" + pivotElement);
    	for (int j = leftIdx; j <= (rightIdx - 1); j++)
    	{
	    System.out.println("partition#" + localCount + ": j= " + j + ", items[j]=" + items[j]);
    	    if (items[j].compareTo(pivotElement) <= 0)
    	    {
    		partitionIdx++;
		System.out.println("partition#" + localCount + ": partitionIdx++= " + partitionIdx);
    		swapItems(partitionIdx, j);
    	    }
    	}
    	swapItems(partitionIdx + 1, rightIdx);
	System.out.println("<<<<partition#" + localCount + ": return val= " + (partitionIdx + 1)); 
    	return partitionIdx + 1;
    }

    private void swapItems(int idx1, int idx2)
    {
	System.out.println("swapItems: idx1= " + idx1 + ", items[idx1]= " + items[idx1] + ", idx2= " + idx2 + ", items[idx2]= " + items[idx2]);
	System.out.println("swapItems: before=" + Arrays.toString(items));
    	T tempItem = items[idx1];
    	items[idx1] = items[idx2];
    	items[idx2] = tempItem;
	System.out.println("swapItems: after=" + Arrays.toString(items));
    }

}
