package com.cdp.thread6;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

public class Runner {
	static {
		BasicConfigurator.configure(
				new ConsoleAppender(new PatternLayout("%C{1}: %m%n")));
	}
	
	public static void main(String[] args) {
		MessageBus messageBus = new AsynchronousMessageBus(3, 10);
		Thread tProducer = new Thread(new Producer(messageBus));
		Thread tConsumer = new Thread(new Consumer(messageBus));
		
		tProducer.start();
		tConsumer.start();
	}
}
