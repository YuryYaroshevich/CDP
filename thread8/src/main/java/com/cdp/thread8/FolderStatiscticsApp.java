package com.cdp.thread8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class FolderStatiscticsApp implements Runnable {
	private static final Logger LOG = Logger.getLogger(Runner.class);
	
	private ExecutorService statiscticsCollectingExecutor = Executors
			.newSingleThreadExecutor();
	private DaemonInterrupter daemonInterrupter;
	
	public FolderStatiscticsApp(DaemonInterrupter daemonInterrupter) {
		this.daemonInterrupter = daemonInterrupter;
	}

	@Override
	public void run() {
		try (Scanner scanIn = new Scanner(System.in)) {
			LOG.info("Enter folder path('x' to exit):");
			
			String dirPath = scanIn.next();
			daemonInterrupter.start();
			
			List<DirStatisticsOperation> statiscticsOperations = new ArrayList<>();
			statiscticsOperations.add(new DirFilesNumStatisticsOperation(dirPath));
			statiscticsOperations.add(new DirSizeStatisticsOperation(dirPath));
			statiscticsOperations.add(new DirFoldersNumStatisticsOperation(dirPath));

			DirStatisticsCollector statiscticsCollector = new DirStatisticsCollector(statiscticsOperations);
			statiscticsCollectingExecutor.submit(statiscticsCollector);
		}	
	}
}
