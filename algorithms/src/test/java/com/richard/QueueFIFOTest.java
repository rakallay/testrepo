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
    public void newQueueNoItems()
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	assertFalse(queue.hasItems());
    }

    @Test
    public void testEnqueueOne() throws QueueEmptyException
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	queue.enqueue(obj);
	assertTrue(queue.hasItems());
	assertTrue("Objects do not match.", obj == queue.dequeue());
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

    @Test(expected = QueueEmptyException.class)
    public void emptiedQueueOneItemDequeue() throws QueueEmptyException
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	queue.enqueue(obj);
	queue.dequeue();
	queue.dequeue();
    }

    @Test
    public void enqueueDequeueTwo() throws QueueEmptyException
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	Object obj2 = new Object();
	queue.enqueue(obj);
	queue.enqueue(obj2);
	Object retObj = queue.dequeue();
	assertTrue(retObj == obj);
	Object retObj2 = queue.dequeue();
	assertTrue(retObj2 == obj2);
	assertFalse(queue.hasItems());
    }

    @Test(expected = QueueEmptyException.class)
    public void enqueueTwoDequeueThree_DequeueException() throws QueueEmptyException
    {
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	Object obj2 = new Object();
	queue.enqueue(obj);
	queue.enqueue(obj2);
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
    }

    @Test
    public void enqueueDequeueThree() throws QueueEmptyException
    {
	// enqueue three items, then dequeue three and make sure right items returned
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	Object obj2 = new Object();
	Object obj3 = new Object();
	queue.enqueue(obj);
	queue.enqueue(obj2);
	queue.enqueue(obj3);
	Object retObj = queue.dequeue();
	assertTrue(retObj == obj);
	Object retObj2 = queue.dequeue();
	assertTrue(retObj2 == obj2);
	Object retObj3 = queue.dequeue();
	assertTrue(retObj3 == obj3);
	assertFalse(queue.hasItems());
    }

    @Test(expected = QueueEmptyException.class)
    public void enqueueThreeDequeueFourException() throws QueueEmptyException
    {
	// enqueue three items, then dequeue four and ensure exception thrown
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	Object obj2 = new Object();
	Object obj3 = new Object();
	queue.enqueue(obj);
	queue.enqueue(obj2);
	queue.enqueue(obj3);
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
    }

    @Test
    public void enqueueThreeDequeueTwoEnqueueTwoDequeueThree() throws QueueEmptyException
    {
	// enqueue three items, then dequeue three and make sure right items returned
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	Object obj2 = new Object();
	Object obj3 = new Object();
	queue.enqueue(obj);
	queue.enqueue(obj2);
	queue.enqueue(obj3);
	Object retObj = queue.dequeue();
	assertTrue(retObj == obj);
	Object retObj2 = queue.dequeue();
	assertTrue(retObj2 == obj2);

	Object obj4 = new Object();
	Object obj5 = new Object();
	queue.enqueue(obj4);
	queue.enqueue(obj5);

	Object retObj3 = queue.dequeue();
	assertTrue(retObj3 == obj3);
	Object retObj4 = queue.dequeue();
	assertTrue(retObj4 == obj4);
	Object retObj5 = queue.dequeue();
	assertTrue(retObj5 == obj5);
	assertFalse(queue.hasItems());
    }

    @Test
    public void enqueueThreeDequeueOneEnqueueOneDequeueThree() throws QueueEmptyException
    {
	// enqueue three items, then dequeue three and make sure right items returned
	QueueFIFO<Object> queue = new QueueFIFO<Object>();
	Object obj = new Object();
	Object obj2 = new Object();
	Object obj3 = new Object();
	queue.enqueue(obj);
	queue.enqueue(obj2);
	queue.enqueue(obj3);
	Object retObj = queue.dequeue();
	assertTrue(retObj == obj);

	Object obj4 =  new Object();
	queue.enqueue(obj4);

	Object retObj2 = queue.dequeue();
	assertTrue(retObj2 == obj2);
	Object retObj3 = queue.dequeue();
	assertTrue(retObj3 == obj3);
	Object retObj4 = queue.dequeue();
	assertTrue(retObj4 == obj4);
	assertFalse(queue.hasItems());
    }
}
