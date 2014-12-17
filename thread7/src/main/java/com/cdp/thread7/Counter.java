package com.cdp.thread7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class Counter {
	private int count;
	private int upperBound;
	private int lowerBound;
	
	private Lock lock = new ReentrantLock();
	private Condition upperBoundReached = lock.newCondition();
	private Condition lowerBoundReached = lock.newCondition();
	
	private static final Logger LOG = Logger.getLogger(Counter.class);
	
	public Counter(int count, int lowerBound, int upperBound) {
		this.count = count;
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}

	public void increment() {
		lock.lock(); 
		try {
			if (count + 1 >= upperBound) {
				upperBoundReached.await();
			}
			count++;
			lowerBoundReached.signal();
		    LOG.info("value was incremented and equal to: " + (count));	
			
			Thread.sleep(500);
		} catch (InterruptedException e) {
			LOG.error(e);
		} finally {
			lock.unlock();
		}
	}

	public void decrement() {
		lock.lock();
		try {
			if (count - 1 <= lowerBound) {
				lowerBoundReached.await();
			}
			count--;
			upperBoundReached.signal();
			LOG.info("value was decremented and equal to: " + (count));
			
			Thread.sleep(500);
		} catch (InterruptedException e) {
			LOG.error(e);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public String toString() {
		return lowerBound + " < counter < " + upperBound;
	}
}
