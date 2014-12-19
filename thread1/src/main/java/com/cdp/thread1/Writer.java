package com.cdp.thread1;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Writer extends Thread {
	private static final Logger LOG = Logger.getLogger(Writer.class);
	
	private SynchronizedFile file;
	
	public Writer(SynchronizedFile file) {
		this.file = file;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; ; i++) {
				file.write(String.valueOf(i) + '\n');
				Thread.sleep(500);
			}	
		} catch (IOException e) {
			LOG.error(e);
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}
}
