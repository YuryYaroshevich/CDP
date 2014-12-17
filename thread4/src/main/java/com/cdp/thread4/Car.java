package com.cdp.thread4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.Logger;

public class Car implements Runnable {
	private static final long MAX_DISTANCE = 10000;
	Logger log = Logger.getLogger(getClass());

	private long distance;
	private String name;
	private CyclicBarrier finish;
	private int finishNum;
	private boolean disqualified;

	public Car(String name) {
		this.name = name;
	}

	public void setFinish(CyclicBarrier finish) {
		this.finish = finish;
		this.disqualified = false;
	}

	@Override
	public void run() {
		try {
			while (distance < MAX_DISTANCE) {
				Thread.sleep(100);
				distance += 100;
				log.info(name + " " + distance);
			}
			
			finishNum = finish.await();
		} catch (InterruptedException e) {
			log.error(e);
			try {
				this.disqualified = true;
				finish.await();
			} catch (InterruptedException e1) {
				log.error(e1);
			} catch (BrokenBarrierException e1) {
				log.error(e1);
			}
		} catch (BrokenBarrierException e) {
			log.error(e);
		}
	}

	public int getFinishNum() {
		return finishNum;
	}

	public boolean isDisqualified() {
		return disqualified;
	}

	public String getName() {
		return name;
	}
}