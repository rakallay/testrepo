package com.richard;

public class Queue<T>
{

    private Node<T> last;
    private Node<T> first;


    public Queue()
    {
    }

    public void enqueue(T data)
    {
	if (last == null)
	{
	    last = new Node(T data);
	    first = last;
	    return;
	}
	Node<T> newNode = new Node(T data);
	last.setNext(newNode);
	last = newNode;
    }

    public T dequeue()
    {
	if (last == null)
	    return null;
	T data = first.getData();
	first = first.getNext();
	if (first == null)
	    last = null;
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
