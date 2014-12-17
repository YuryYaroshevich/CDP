package com.cdp.thread4;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FinishAnnouncer implements Runnable {
	private static final Logger LOG = Logger.getLogger(FinishAnnouncer.class);
	
	private Car[] cars;
	
	public FinishAnnouncer(Car[] cars) {
		this.cars = cars;
	}
	
	@Override
	public void run() {
		List<Car> notDisqualifiedCars = new ArrayList<>();
		for (Car car : cars) {
			if (!car.isDisqualified()) {
				notDisqualifiedCars.add(car);
			}
		}
		int disqualifiedNum = cars.length - notDisqualifiedCars.size();
		for (Car car : notDisqualifiedCars) {
			if (car.getFinishNum() == cars.length - 1 - disqualifiedNum) {
				LOG.info("The winner is " + car.getName() + "!!!");
				return;
			}
		}
		LOG.info("All cars were disqualified.");
	}

}
