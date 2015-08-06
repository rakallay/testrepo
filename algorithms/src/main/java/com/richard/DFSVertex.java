package com.richard;

import com.richard.Vertex;

public class DFSVertex extends Vertex {

    private long discoveredTime;
    private long finishedTime;

    public DFSVertex(String name)
    {
	super(name);
    }

    public long getDiscoveredTime()
    {
	return discoveredTime;
    }

    public void setDiscoveredTime(long discoveredTime)
    {
	this.discoveredTime = discoveredTime;
    }

    public long getFinishedTime()
    {
	return finishedTime;
    }

    public void setFinishedTime(long finishedTime)
    {
	this.finishedTime = finishedTime;
    }

}
