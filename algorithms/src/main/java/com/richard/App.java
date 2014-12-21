package com.richard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

import com.richard.QuickSorter;
import com.richard.MergeSorter;

/**
 * Hello world!
 *
 */
public class App 
{
	private enum SORT_ALGORITHM
	{
		QUICKSORT,
		MERGESORT,
		UNKNOWN;

		public static SORT_ALGORITHM getAlgorithmFromString(String algStr)
		{
			if ("mergesort".equalsIgnoreCase(algStr))
			{
				return MERGESORT;
			}
			else if ("quicksort".equalsIgnoreCase(algStr))
			{
				return QUICKSORT;
			}
			else
			{
				return UNKNOWN;
			}
		}
	}
    
    private enum DATA_INIT_ORDER
    {
        REVERSE_SORTED,
        SORTED,
        RANDOM,
        UNKNOWN;
        
        public static DATA_INIT_ORDER getDataInitOrderFromString(String order)
        {
            if ("reverse".equalsIgnoreCase(order))
            {
                return REVERSE_SORTED;
            }
            else if ("sorted".equalsIgnoreCase(order))
            {
                return SORTED;
            }
            else if ("random".equalsIgnoreCase(order))
            {
                return RANDOM;
            }
            else
            {
                return UNKNOWN;    
            }
        }
    }

    public static void main( String[] args )
    {
    	if (args.length != 3)
    	{
    		printUsage();
    		System.exit(1);
    	}

 		String[] userSpecifiedAlgorithms = args[0].split(",");
 		SORT_ALGORITHM[] sortAlgorithms = new SORT_ALGORITHM[userSpecifiedAlgorithms.length];
 		for (int algIdx = 0; algIdx < userSpecifiedAlgorithms.length; algIdx++)
 		{
 			sortAlgorithms[algIdx] = SORT_ALGORITHM.getAlgorithmFromString(userSpecifiedAlgorithms[algIdx]);
 			if (sortAlgorithms[algIdx] == SORT_ALGORITHM.UNKNOWN)
 			{
 				System.out.println("Unrecognized sorting algorithm specified: " + userSpecifiedAlgorithms[algIdx]);
 				System.exit(1);
 			}
 		}

 		int count = 0;
 		try
 		{
            count = Integer.valueOf(args[1]);
 		}
 		catch(NumberFormatException e)
 		{
            System.out.println("Invalid number count specified: " + args[1]);
            System.exit(1);
 		}

        DATA_INIT_ORDER order = DATA_INIT_ORDER.getDataInitOrderFromString(args[2]);
        if (order == DATA_INIT_ORDER.UNKNOWN)
        {
            System.out.println("Unknown data init order: " + args[2]);
            printUsage();
            System.exit(1);
        }

        for (SORT_ALGORITHM alg : sortAlgorithms)
        {
            Integer numbers[] = new Integer[count];
            initializeNumbers(numbers, order);
            
            switch(alg)
            {
                case QUICKSORT:
                {
                    System.out.println("Running quicksort algorithm");
                    QuickSorter<Integer> sorter = new QuickSorter<Integer>(numbers);
                    //System.out.println("Beginning numbers: " + Arrays.toString(numbers));
                    long startTime = System.currentTimeMillis();
                    sorter.sort();
                    long endTime = System.currentTimeMillis();
                    if (!validateSorted(numbers))
                    {
                        System.exit(1);
                    }
                    //System.out.println("Sorted numbers: " + Arrays.toString(numbers));
                    System.out.println("Total time(milliseconds): " + (endTime - startTime));
                    break;
                }
                case MERGESORT:
                {
                    System.out.println("Running mergesort algorithm");
                    MergeSorter<Integer> mergeSorter = new MergeSorter<Integer>(numbers);
                    //System.out.println("Beginning numbers: " + Arrays.toString(numbers));
                    long startTime = System.currentTimeMillis();
                    mergeSorter.sort();
                    long endTime = System.currentTimeMillis();
                    if (!validateSorted(numbers))
                    {
                        System.exit(1);
                    }
                    //System.out.println("Sorted numbers: " + Arrays.toString(numbers));
                    System.out.println("Total time(milliseconds): " + (endTime - startTime));
                    break;
                }            
            }    
        }
	}

	private static void printUsage()
	{
		System.out.println("Usage: App <algorithm>[,algorithm] <count> <data init order>");
    	System.out.println("algorithm: one or more sorting algorithms, comma separated.");
        System.out.println("           Possible values are: quicksort or mergesort.");
    	System.out.println("           Multiple algorithms can be specified, ex. \"quicksort,mergesort\"");
    	System.out.println("count: the number of numbers to sort");
        System.out.println("data init order: one of reverse, sorted, or random");
	}

    private static void initializeNumbers(Integer[] numbers, DATA_INIT_ORDER order)
    {
        switch(order)
        {
            case REVERSE_SORTED:
            {
                for (int i = 0;i < numbers.length; i++)
                {
                    numbers[i] = (numbers.length - i);
                }
                break;
            }
            case SORTED:
            {
                for (int i = 0;i < numbers.length; i++)
                {
                    numbers[i] = i;
                }
                break;
            }
            case RANDOM:
            {
                for (int i = 0;i < numbers.length; i++)
                {
                    numbers[i] = (int)(Math.random() * numbers.length);
                }
                break;
            }
        }
    }
    
    private static boolean validateSorted(Integer[] numbers)
    {
        for (int i = 1; i < numbers.length; i++)
        {
            if (numbers[i].compareTo(numbers[i - 1]) < 0)
            {
                System.out.println("Invalid order: numbers[" + i + "], numbers[" + i + "]");
                return false;
            }
        }
        return true;
    }

/*    public void BFSGraphSearch()
    {
	System.out.println( "Hello World!" );
        
        HashMap<Vertex, ArrayList<Vertex>> adjacencyList = new HashMap<Vertex, ArrayList<Vertex>>();
        
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        
        ArrayList<Vertex>.reachableVertices = null;
        reachableVertices.add(b);
        reachableVertices.add(c);
        adjacencyList.put(a, reachableVertices);
        
        reachableVertices = new ArrayList<Vertex>();
        reachableVertices.add(c);
        adjacencyList.put(b, reachableVertices);
        
        reachableVertices = new ArrayList<Vertex>();
        reachableVertices.add(a);
        adjacencyList.put(c, reachableVertices);
        
    }
*/
}
