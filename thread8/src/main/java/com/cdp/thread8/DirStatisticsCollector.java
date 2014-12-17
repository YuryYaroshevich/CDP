package com.cdp.thread8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

public class DirStatisticsCollector implements Runnable {
	private static final Logger LOG = Logger.getLogger(DirStatisticsCollector.class);
	
	private List<DirStatisticsOperation> operations;
	private ExecutorService operationExecutor;
	
	public DirStatisticsCollector(List<DirStatisticsOperation> operations) {
		this.operations = operations;
		this.operationExecutor = Executors.newFixedThreadPool(operations.size());
	}

	@Override
	public void run() {
		LOG.info("Statisctics collecting is started.");
		List<Future<?>> doneIndicators = new ArrayList<>();
		for (DirStatisticsOperation operation : operations) {
			Future<?> doneIndicator = operationExecutor.submit(operation);
			doneIndicators.add(doneIndicator);
		}
		
		while (true) {
			if (Thread.interrupted()) {
				operationExecutor.shutdownNow();
				LOG.info("Statisctics collecting is interrapted.");
				break;
			}
			int numberOfDone = 0;
			for (Future<?> doneIndicator : doneIndicators) {
				numberOfDone += doneIndicator.isDone() ? 1 : 0;
			}
			if (numberOfDone == doneIndicators.size()) {
				LOG.info("Statisctics collecting is done.");
				break;
			}			
		}
		operationExecutor.shutdownNow();
	}
}
