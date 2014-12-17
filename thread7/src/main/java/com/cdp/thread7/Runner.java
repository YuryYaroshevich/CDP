package com.cdp.thread7;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class Runner {
	private static final Logger LOG = Logger.getLogger(Counter.class);
	
	static {
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(
				"%C{1}: %m%n")));
	}

	public static void main(String[] args) {
		Counter counter = new Counter(10, 5, 10);
		LOG.info("initial value = " + 10);
		LOG.info("using counter: " + counter);
		
		Thread tIncrementor = new Thread(new Incrementor(counter));
		Thread tDecrementor = new Thread(new Decrementor(counter));
		
		tDecrementor.start();
		tIncrementor.start();
	}
}
