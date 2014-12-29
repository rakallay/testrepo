package com.richard;

import com.richard.BFSGraphSearch;
import java.util.ArrayList;
import java.util.HashMap;

public class GraphSearcher
{
    
    public static void main(String[] args)
    {
	GraphSearcher searcher = new GraphSearcher();
	searcher.BFSGraphSearch();
    }
    
    public void BFSGraphSearch()
    {
        HashMap<Vertex, ArrayList<Vertex>> adjacencyList = new HashMap<Vertex, ArrayList<Vertex>>();
        
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");

	ArrayList<Vertex> allVertices = new ArrayList<Vertex>();
	allVertices.add(a);
	allVertices.add(b);
	allVertices.add(c);
	allVertices.add(d);
	allVertices.add(e);

        ArrayList<Vertex> reachableVertices = new ArrayList<Vertex>();
        reachableVertices.add(b);
        reachableVertices.add(c);
        adjacencyList.put(a, reachableVertices);
        
        reachableVertices = new ArrayList<Vertex>();
        reachableVertices.add(c);
        adjacencyList.put(b, reachableVertices);
        
        reachableVertices = new ArrayList<Vertex>();
        reachableVertices.add(a);
	reachableVertices.add(d);
        adjacencyList.put(c, reachableVertices);

        reachableVertices = new ArrayList<Vertex>();
        reachableVertices.add(e);
        adjacencyList.put(d, reachableVertices);

	BFSGraphSearch search = new BFSGraphSearch(allVertices, a, adjacencyList);
	search.analyze();

	search.printGraphDistances();
    }

}

