package com.cdp.thread7;

public class Decrementor implements Runnable {
	private Counter counter;

	public Decrementor(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while (true) {
			counter.decrement();
		}
	}

}
