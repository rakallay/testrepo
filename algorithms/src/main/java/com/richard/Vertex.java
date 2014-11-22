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
	
	public void incrementDistance()
	{
		distance++;
	}
	
	public void setPredecessor(Vertex v)
	{
		this.predecessor = v;
	}
	
	@Override @Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
