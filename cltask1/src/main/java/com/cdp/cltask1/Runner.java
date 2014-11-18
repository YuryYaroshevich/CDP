package com.cdp.cltask1;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class Runner {
	static Logger log = Logger.getLogger(Runner.class);
	
	static {
		BasicConfigurator.configure(
				new ConsoleAppender(new PatternLayout("%m%n")));
	}
	
	public static void main(String[] args) throws IOException {
		new Menu().start();
	}
}
