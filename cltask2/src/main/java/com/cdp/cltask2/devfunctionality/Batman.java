package com.cdp.cltask2.devfunctionality;

import org.apache.log4j.Logger;

public class Batman {
	private static final Logger log = Logger.getLogger(Batman.class);
	
	private BatCar batCar = new BatCar();
	
	public void saveTheWorld() {
		log.info("I'm saving the world");
		batCar.move();
	}

}
