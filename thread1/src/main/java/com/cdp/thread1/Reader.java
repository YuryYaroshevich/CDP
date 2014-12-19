package com.cdp.thread1;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Reader extends Thread {
	private static final Logger LOG = Logger.getLogger(Writer.class);
	
	private SynchronizedFile file;
	
	public Reader(SynchronizedFile file) {
		this.file = file;
	}

	@Override
	public void run() {
		try {
			long skipBytes = 0;
			while (true) {
				String readedData = file.read(skipBytes);
				System.out.print(readedData);
				skipBytes += readedData.getBytes().length;
				Thread.sleep(500);
			}
		} catch (IOException e) {
			LOG.error(e);
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}
}
