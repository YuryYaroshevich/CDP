package com.cdp.thread8;

import java.io.File;

import org.apache.log4j.Logger;

public class DirSizeStatisticsOperation extends DirStatisticsOperation {
	private static final Logger LOG = Logger.getLogger(DirFoldersNumStatisticsOperation.class);
	
	public DirSizeStatisticsOperation(String dirPath) {
		super(dirPath);
	}

	@Override
	public void run() {
		LOG.info("Start counting size of " + dirPath + " directory.");
		File dir = new File(dirPath);
		long size = countSize(dir);
		if (Thread.currentThread().isInterrupted()) {
			return;
		}
		try {
			Thread.sleep(4500);
			LOG.info("Size of " + dirPath + " is equal to " + size + " bytes.");
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}
	
	private long countSize(File file) {
		long size = 0;
		if (file.isDirectory()) {
			File dir = file;
			for (File f : dir.listFiles()) {
				size += f.isDirectory() ? countSize(f) : f.length();
			}
		} else {
			return file.length();
		}
		return size;
	}
}
