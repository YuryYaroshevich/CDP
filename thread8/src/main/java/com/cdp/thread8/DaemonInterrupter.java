package com.cdp.thread8;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class DaemonInterrupter extends Thread {
	private ExecutorService mainTaskExecutor;

	public DaemonInterrupter(ExecutorService mainTaskExecutor) {
		super();
		setDaemon(true);
		this.mainTaskExecutor = mainTaskExecutor;
	}

	@Override
	public void run() {
		try (Scanner scanIn = new Scanner(System.in)) {
			while (true) {
				if (scanIn.hasNext()) {
					interruptIfNeed(scanIn.next());
				}				
			}
		}
	}
	
	private void interruptIfNeed(String interruptCommand) {
		if ("x".equals(interruptCommand)) {
			mainTaskExecutor.shutdownNow();
		}
	}
}
