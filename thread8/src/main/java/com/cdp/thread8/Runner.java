package com.cdp.thread8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class Runner {
	private static final Logger LOG = Logger.getLogger(Runner.class);
	
	static {
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(
				"%m%n")));
	}

	public static void main(String[] args) {		
		try (Scanner scanIn = new Scanner(System.in)) {
			LOG.info("Enter folder path('x' to stop):");			
			String dirPath = scanIn.next();			
			
			List<DirStatisticsOperation> statiscticsOperations = new ArrayList<>();
			statiscticsOperations.add(new DirFilesNumStatisticsOperation(dirPath));
			statiscticsOperations.add(new DirSizeStatisticsOperation(dirPath));
			statiscticsOperations.add(new DirFoldersNumStatisticsOperation(dirPath));

			DirStatisticsCollector statiscticsCollector = 
					new DirStatisticsCollector(statiscticsOperations);
			DaemonInterrupter interrupter = new DaemonInterrupter(statiscticsCollector.getEngine());
			interrupter.start();
			statiscticsCollector.collect();			
		}	
	}
}