package com.cdp.cltask2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;


public class Runner {
	static {
		BasicConfigurator.configure(
				new ConsoleAppender(new PatternLayout("%m%n")));
	}
	
	public static void main(String[] args) {
		
		new Menu().start();
	}
}
