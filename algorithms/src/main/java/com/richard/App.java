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
    public static void main( String[] args )
    {
	Integer numbers[] = new Integer[10];
	for (int i = 0;i < 10; i++)
	{
	    numbers[i] = (10 - i);
	}
        QuickSorter<Integer> sorter = new QuickSorter<Integer>(numbers);
	

	System.out.println("Beginning numbers: " + Arrays.toString(numbers));
	sorter.sort();
	System.out.println("Sorted numbers: " + Arrays.toString(numbers));
	System.out.print("[ " + numbers[0]);
	for (int i = 1;i < numbers.length; i++)
	{
	    System.out.print(" ," + numbers[i]);
	}
	System.out.println(" ]");

	numbers = new Integer[10];
	for (int i = 0;i < 10; i++)
	{
	    numbers[i] = (10 - i);
	}
        MergeSorter mergeSorter = new MergeSorter(numbers);
	

	System.out.println("Beginning numbers: " + Arrays.toString(numbers));
	mergeSorter.sort();
	System.out.println("Sorted numbers: " + Arrays.toString(numbers));
	System.out.print("[ " + numbers[0]);
	for (int i = 1;i < numbers.length; i++)
	{
	    System.out.print(" ," + numbers[i]);
	}
	System.out.println(" ]");
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
