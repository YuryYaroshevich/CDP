package com.cdp.cltask3;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;


public class Runner {
	static {
		BasicConfigurator.configure(
				new ConsoleAppender(new PatternLayout("%m%n")));
	}
	
	public static void main(String[] args) {
		new App().start(args[0]);
	}
}
