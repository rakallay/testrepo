package com.richard;

public class Vertex {
	
	private String name;
	private long distance;
	
	public Vertex(String name){
		this.name = name;
		this.distance = -1;
	}
	
	public String getName(){
		return this.name;
	}
}
