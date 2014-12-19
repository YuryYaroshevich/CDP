package com.cdp.thread1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

/**
 * Hello world!
 *
 */
public class Runner {
	static {
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(
				"%m%n")));
	}

	public static void main(String[] args) {
		SynchronizedFile file = new SynchronizedFile("data.txt");
		Reader reader = new Reader(file);
		Writer writer = new Writer(file);
		
		reader.start();
		writer.start();
	}
}
