package com.richard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QuickSorter<int> sorter = new QuickSorter<int>();
	int numbers[] = new int[10]();
	for (int i = 0;i < 10; i++)
	{
	    numbers[i] = (10 - i);
	}

	sorter.sort(numbers);
	System.out.println("Sorted numbers: " + numbers);
    }

    public void BFSGraphSearch()
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

}
