package com.richard;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.rules.ExpectedException;

import com.richard.Stack;

public class StackTest
{

    @Test
    public void emptyStack()
    {
	Stack stack = new Stack();
	assertTrue(stack.isEmpty());
	assertEquals(stack.pop(), null);
    }

    @Test
    public void oneElement()
    {
	Stack<Integer> stack = new Stack<Integer>();
	stack.push(1);
	assertFalse(stack.isEmpty());
	int data = stack.pop();
	assertEquals(data, 1);
	assertTrue(stack.isEmpty());
	assertEquals(stack.pop(), null);
    }

    @Test
    public void twoElements()
    {
	Stack<Object> stack = new Stack<Object>();
	Object obj1 = new Object();
	stack.push(obj1);
	
	Object obj2 = new Object();
	stack.push(obj2);

	assertFalse(stack.isEmpty());

	Object retObj = stack.pop();
	assertTrue(obj2 == retObj);

	retObj = stack.pop();
	assertFalse(obj2 == retObj);
	assertTrue(obj1 == retObj);
    }

    @Test
    public void threeElements()
    {
	Stack<Object> stack = new Stack<Object>();
	Object obj1 = new Object();
	stack.push(obj1);
	
	Object obj2 = new Object();
	stack.push(obj2);

	Object obj3 = new Object();
	stack.push(obj3);

	assertFalse(stack.isEmpty());

	Object retObj = stack.pop();
	assertTrue(obj3 == retObj);

	retObj = stack.pop();
	assertTrue(obj2 == retObj);

	retObj = stack.pop();
	assertTrue(obj1 == retObj);
    }

}
