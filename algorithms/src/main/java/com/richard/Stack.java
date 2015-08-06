package com.richard;

public class Stack<T>
{

    private Node<T> top;

    public Stack()
    {
    }

    public void push(T data)
    {
	if (top == null)
	{
	    top = new Node<T>(data);
	    return;
	}
	Node<T> newNode = new Node<T>(data);
	newNode.setNext (top);
	top = newNode;
    }

    public T pop()
    {
	if (top != null)
	{
	    T data = top.getData();
	    top = top.getNext();
	    return data;
	}
	return null;
    }

    public boolean isEmpty()
    {
	return top == null;
    }

    private static class Node<T>
    {
	private final T data;
	private Node<T> next;

	public Node(T data)
	{
	    this.data = data;
	}

	public T getData()
	{
	    return data;
	}

	public Node<T> getNext()
	{
	    return next;
	}

	public void setNext(Node<T> next)
	{
	    this.next = next;
	}
    }
}
