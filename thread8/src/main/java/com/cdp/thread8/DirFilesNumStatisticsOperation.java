package com.cdp.thread8;

import java.io.File;

import org.apache.log4j.Logger;

public class DirFilesNumStatisticsOperation extends DirStatisticsOperation {
	private static final Logger LOG = Logger.getLogger(DirFilesNumStatisticsOperation.class);

	public DirFilesNumStatisticsOperation(String dirPath) {
		super(dirPath);
	}

	@Override
	public void run() {
		LOG.info("Start counting files in " + dirPath + " directory.");
		File dir = new File(dirPath);
		int filesNum = countFiles(dir);
		if (Thread.currentThread().isInterrupted()) {
			return;
		}
		try {
			Thread.sleep(5000);
			LOG.info("Directory " + dirPath + " contains " + filesNum + " files.");
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}
	
	private int countFiles(File file) {
		int filesNum = 0;
		if (file.isDirectory()) {
			File dir = file;
			for (File f : dir.listFiles()) {
				filesNum += countFiles(f);
			}
		} else {
			return 1;
		}
		return filesNum;
	}
	
}
