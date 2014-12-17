package com.cdp.thread8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

public class DirStatisticsCollector {
	private static final Logger LOG = Logger.getLogger(DirStatisticsCollector.class);
	
	private List<DirStatisticsOperation> operations;
	private ExecutorService operationExecutor;
	
	public DirStatisticsCollector(List<DirStatisticsOperation> operations) {
		this.operations = operations;
		this.operationExecutor = Executors.newFixedThreadPool(operations.size());
	}

	public ExecutorService getEngine() {
		return operationExecutor;
	}
	
	public void collect() {
		LOG.info("Statisctics collecting is started.");
		List<Future<?>> doneIndicators = new ArrayList<>();
		for (DirStatisticsOperation operation : operations) {
			Future<?> doneIndicator = operationExecutor.submit(operation);
			doneIndicators.add(doneIndicator);
		}
		
		while (true) {
			int numberOfDone = 0;
			for (Future<?> doneIndicator : doneIndicators) {
				numberOfDone += doneIndicator.isDone() || doneIndicator.isCancelled() ? 1 : 0;
			}
			if (numberOfDone == doneIndicators.size()) {
				LOG.info("Statisctics collecting is done.");
				operationExecutor.shutdownNow();
				break;
			}			
		}
	}
}
