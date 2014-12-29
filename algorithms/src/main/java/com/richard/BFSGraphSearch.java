package com.richard;

import java.util.ArrayList;
import java.util.HashMap;
import com.richard.QueueFIFO;
import com.richard.VertexColor;
import java.util.List;

public class BFSGraphSearch {

    private List<Vertex> allVertices;
    private Vertex source;
    private HashMap<Vertex, ArrayList<Vertex>> adjacencyList;
    
    public BFSGraphSearch(List<Vertex> allVertices, Vertex source, HashMap<Vertex, ArrayList<Vertex>> adjacencyList) {
	this.source = source;
	this.adjacencyList = adjacencyList;
	this.allVertices = allVertices;
    }
    
    public Vertex analyze()
    {

	for (Vertex v : allVertices)
	{
	    v.setColor(VertexColor.WHITE);
	    v.setDistance(-1);
	    v.setPredecessor(null);
	}

	QueueFIFO<Vertex> vertexQueue = new QueueFIFO<Vertex>();

	source.setColor(VertexColor.GRAY);
	source.setDistance(0);
	source.setPredecessor(null);

	// add the source vertex to the queue
	vertexQueue.enqueue(source);

	// while the queue is not empty
	while(vertexQueue.hasItems())
	{
	    //  pop a vertex off of the queue
	    Vertex v = null;
	    try
	    {
		v = vertexQueue.dequeue();
	    }
	    catch(QueueEmptyException e)
	    {
		System.out.println("Unexpected empty queue exception caught: " + e.getMessage());
		continue;
	    }
	    //  go through all of the vertices adjacent to the vertex just popped off
	    if (adjacencyList.get(v) == null)
	    {
		v.setColor(VertexColor.BLACK);
		continue;
	    }
	    ArrayList<Vertex> vertexList = adjacencyList.get(v);
	    for (Vertex adjcVertex : vertexList)
	    {
		//    if the vertex is white
		//      color it grey
		//      set its distance to be one plus the distance of the vertex popped off
		//      add it to the queue
		//    else color it black
		if (adjcVertex.getColor() == VertexColor.WHITE)
		{
		    adjcVertex.setColor(VertexColor.GRAY);
		    adjcVertex.setDistance(v.getDistance() + 1);
		    adjcVertex.setPredecessor(v);
		    vertexQueue.enqueue(adjcVertex);
		}
	    }
	    v.setColor(VertexColor.BLACK);
	}
	return null;
    }
    
    public void printGraphDistances()
    {
	for (Vertex v : allVertices)
	{
	    System.out.println ("Vertex: " + v.toString());
	}
    }
	
}
