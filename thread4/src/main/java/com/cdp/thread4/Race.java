package com.cdp.thread4;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

public class Race {
	static {
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(
				"%m%n")));
	}

	public static void main(String[] args) throws InterruptedException {
		final Car[] cars = { new Car("ferrari"), new Car("porsche"),
				new Car("lamborghini") };
		CyclicBarrier finish = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				new Thread(new FinishAnnouncer(cars)).start();
			}
		});
		for (Car car : cars) {
			car.setFinish(finish);
		} 
		
		Thread[] roads = new Thread[cars.length];
		for (int i = 0; i < roads.length; i++) {
			roads[i] = new Thread(cars[i]);
		}
		
		for (Thread road : roads) {
			road.start();
		}
		
		Thread.sleep(5000);
		roads[new Random().nextInt(3)].interrupt();
	}
}
