package com.cdp.cltask32;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class Runner {
	private static Logger log = Logger.getLogger(Runner.class);
	static {
		BasicConfigurator.configure(
				new ConsoleAppender(new PatternLayout("%m%n")));
	}
	
	private static App app = new App();
	
	public static void main(String[] args) {
		try (Scanner scanIn = new Scanner(System.in)) {
			while (true) {
				log.info("Enter class path:");
				String classPath = scanIn.nextLine();
				if ("bye".equals(classPath)) {
					break;
				}
				app.run(classPath);
				log.info("#######");
			}
		}
	}
}
