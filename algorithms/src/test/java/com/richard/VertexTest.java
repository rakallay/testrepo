package com.richard;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.rules.ExpectedException;

import com.richard.Vertex;
import com.richard.VertexColor;

import java.util.HashMap;

public class VertexTest
{
    @Test
    public void equals_Equals()
    {
	Vertex v = new Vertex("a");
	assertTrue(v.equals(v));
	
	Vertex v2 = new Vertex("a");
	assertTrue(v.equals(v2));
	assertEquals(v.getDistance(), v2.getDistance());
	assertEquals(v.getName(), v2.getName());
	assertEquals(v.getPredecessor(), v2.getPredecessor());
	assertEquals(v.getColor(), v2.getColor());

	v2.setDistance(100);
	assertTrue(v.getDistance() != v2.getDistance());
	assertTrue(v.equals(v2));

	v2.setColor(VertexColor.GRAY);
	assertTrue(v.getColor() != v2.getColor());
	assertTrue(v.equals(v2));

	Vertex v3 = new Vertex("c");
	v2.setPredecessor(v3);
	assertTrue(v.equals(v2));
    }

    @Test
    public void equals_NotEquals()
    {
	Vertex v = new Vertex("a");
	assertTrue(v.equals(v));
	
	Vertex v2 = new Vertex("b");
	assertFalse(v.equals(v2));
	assertEquals(v.getDistance(), v2.getDistance());
	assertNotEquals(v.getName(), v2.getName());
	assertEquals(v.getPredecessor(), v2.getPredecessor());
	assertEquals(v.getColor(), v2.getColor());

	assertFalse(v.equals(null));
    }

    @Test
    public void hashCodeTest()
    {
	HashMap<Vertex, Vertex> testMap = new HashMap<Vertex, Vertex>();

	Vertex v = new Vertex("a");
	testMap.put(v, v);

	Vertex v2 = testMap.get(v);
	assertTrue(v == v2);

	Vertex v3 = new Vertex("a");
	testMap.put(v3, v3);
	v2 = testMap.get(v3);
	assertTrue(v2 == v3);
	assertFalse(v == v3);
    }
}
