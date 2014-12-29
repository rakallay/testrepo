package com.richard;

import com.richard.QueueEmptyException;

public class QueueFIFO<T>
{
    private Node<T> head;
    private Node<T> tail;

    public QueueFIFO()
    {
	this.head = null;
	this.tail = null;
    }

    public void enqueue(T data)
    {
	if (data == null)
	    throw new NullPointerException("Data cannot be null");
	Node<T> newNode = new Node<T>(data);
	// first element
	if (tail == null)
	{
	    tail = newNode;
	}
	// one or more elements
	else
	{
	    head.setPrev(newNode);
	}
	head = newNode;
    }

    public T dequeue() throws QueueEmptyException
    {
	if (!hasItems())
	    throw new QueueEmptyException("Dequeue attempted on empty queue.");
	T data = tail.getData();
	// one item
	if (head == tail)
	{
	    head = null;
	    tail = null;
	}
	// two or more items.  Just move tail up one
	else
	{
	    tail = tail.getPrev();
	}
	return data;
    }

    public boolean hasItems()
    {
	return !(head == tail && head == null);
    }
    

    private static class Node<U>
    {
	private Node<U> prev;
	private U data;

	private Node()
	{
	    this.prev = null;
	    this.data = null;
	}

	public Node(U data)
	{
	    this.prev = null;
	    this.data = data;
	}

	public Node(U data, Node<U> prev)
	{
	    this.data = data;
	    this.prev = prev;
	}

	public U getData()
	{
	    return data;
	}

	public Node<U> getPrev()
	{
	    return prev;
	}

	public void setPrev(Node<U> prev)
	{
	    this.prev = prev;
	}
    }

}
