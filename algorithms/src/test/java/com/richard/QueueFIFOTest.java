package com.richard;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.rules.ExpectedException;

import com.richard.QueueFIFO;
import com.richard.QueueEmptyException;

public class QueueFIFOTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = QueueEmptyException.class)
    public void dequeEmptyThrowsException() throws QueueEmptyException
    {
	QueueFIFO<Integer> queue = new QueueFIFO<Integer>();
	Integer i = queue.dequeue();
    }

    @Test(expected = NullPointerException.class)
    public void enqueueNull()
    {
	QueueFIFO<Integer> queue = new QueueFIFO<Integer>();
	queue.enqueue(null);
    }

    @Test
    public void testOne() throws QueueEmptyException
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	queue.enqueue(obj);
	assertTrue("Objects do not match.", obj == queue.dequeue());
    }

    @Test
    public void newQueueNoItems()
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	assertFalse(queue.hasItems());
    }

    @Test
    public void emptiedQueueOneItemNoItems() throws QueueEmptyException
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	queue.enqueue(obj);
	assertTrue("Objects do not match.", obj == queue.dequeue());
	assertFalse("hasItems returned true.", queue.hasItems());
    }

    //@Test
    public void testOneDequeueTwice() throws QueueEmptyException
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	queue.enqueue(obj);
	assertTrue("Objects do not match.", obj == queue.dequeue());

	thrown.expect(QueueEmptyException.class);
        thrown.expectMessage("Dequeue attempted on empty queue.");
	queue.dequeue();

    }

}
