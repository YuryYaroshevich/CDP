package com.cdp.thread8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;


public class Runner {
	
	static {
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(
				"%m%n")));
	}

	public static void main(String[] args) {
		ExecutorService mainTaskExecutor = Executors.newSingleThreadExecutor();
		DaemonInterrupter interrupter = new DaemonInterrupter(mainTaskExecutor);
		mainTaskExecutor.submit(new FolderStatiscticsApp(interrupter));
	}
}