
public class QuickSorter<T>
{
    public QuickSorter<T>()
    {
    }

    public void sort(T[] items)
    {
	if (items == null)
	    throw new InvalidArgumentException("items to sort cannot be null");
	
	if (items.length == 0)
	    return;
	
	int pivot = items.length / 2;
	quicksort(items, 0, items.length - 1, pivot);

    }

    private void quicksort(T[] items, int left, int right, int pivot)
    {
	if (left == right)
	    return;

	if (left > right)
	    return;

	int leftToSwap = 0;
	int rightToSwap = 0;

	while(left < right)
	{
	    int leftToSwap = 0;
	    int rightToSwap = 0;

	    for (int l = 0; l < pivot; l++)
	    {
		if (items[l].compareTo(items[pivot]) > 0)
		{
		    leftToSwap = l;
		    break;
		}
	    }

	    for (int r = right; r > pivot; r--)
	    {
		if (items[r].compareTo(items[pivot]) < 0)
		{
		    rightToSwap = r;
		    break;
		}
	    }

	    if (leftToSwap != 0 && rightToSwap != 0)
	    {
		swapItems(items, leftToSwap, rightToSwap);
		left++;
		right--;
	    }

	    if (leftToSwap != 0)
	    {
		swapItems(items, leftToSwap, pivot

	}
    }

}
