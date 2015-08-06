package com.richard;

import java.util.List;

public class DFSGraphSearch {

    private final List<DFSVertex> vertices;
    private final boolean[][] adjacencyMatrix;

    public DFSGraphSearch(List<DFSVertex> vertices, boolean[][] adjacencyMatrix)
    {
	this.vertices = vertices;
	this.adjacencyMatrix = adjacencyMatrix;
    } 

    public void search()
    {
	for (DFSVertex vertex : vertices)
	{
	    vertex.setColor(VertexColor.WHITE);
	    vertex.setPredecessor(Vertex.NULL_VERTEX);
	}

	for (int i = 0; i < vertices.size(); i++)
	{
	    DFSVertex vertex = vertices.get(i);
	    if (vertex.getColor() == VertexColor.WHITE)
	    {
		dfsVisit(vertex, adjacencyMatrix[i]);
	    }
	}
    }

    public void dfsVisit(DFSVertex vertex, boolean[] adjacencyRow)
    {
	vertex.setDiscoveredTime(System.currentTimeMillis());
	vertex.setColor(VertexColor.GRAY);
	
	
	for (int i = 0; i < adjacencyRow.length; i++)
	{
	    DFSVertex possibleAdjVertex = vertices.get(i);
	    if (adjacencyRow[i] && possibleAdjVertex != Vertex.NULL_VERTEX &&
	        possibleAdjVertex != vertex)
	    {


		if (possibleAdjVertex.getColor() == VertexColor.WHITE)
		{
		    possibleAdjVertex.setPredecessor(vertex);
		    dfsVisit(possibleAdjVertex, adjacencyMatrix[i]);
		}
	    }
	}
	vertex.setColor(VertexColor.BLACK);
	vertex.setFinishedTime(System.currentTimeMillis());
    }
}
