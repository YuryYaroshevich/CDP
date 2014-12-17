package com.cdp.thread7;

public class Incrementor implements Runnable {
	private Counter counter;

	public Incrementor(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while (true) {
			counter.increment();
		}
	}
}
