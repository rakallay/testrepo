package com.richard;

public class Vertex {
	
    private String name;
    private long distance;
    private VertexColor color;
    private Vertex predecessor;
    
    public static final Vertex NULL_VERTEX = new Vertex();
    
    private Vertex()
    {
	this.name = null;
	this.distance = -1;
	this.color = null;
	this.predecessor = null;
    }
    
    public Vertex(String name){
	this.name = name;
	this.distance = -1;
	this.predecessor = NULL_VERTEX;
    }
    
    public String getName(){
	return this.name;
    }
    
    public long getDistance()
    {
	return this.distance;
    }

    public void setDistance(long distance)
    {
	this.distance = distance;
    }
    
    public VertexColor getColor()
    {
	return color;
    }

    public void setColor(VertexColor color)
    {
	this.color = color;
    }
    
    public Vertex getPredecessor()
    {
	return predecessor;
    }

    public void setPredecessor(Vertex v)
    {
	this.predecessor = v;
    }
    
    @Override
    public boolean equals(Object obj) 
    {
	if (obj == null)
	    return false;
	if (this.name == null && ((Vertex)obj).getName() == null)
	    return true;
	if (this.name == null)
	    return false;
	return this.name.equals(((Vertex)obj).getName());
    }
    
    @Override
    public int hashCode() {
	int result = 1;
	result = result * 37 + (this.name == null ? 0 : this.name.hashCode());
	return result;
    }
}
