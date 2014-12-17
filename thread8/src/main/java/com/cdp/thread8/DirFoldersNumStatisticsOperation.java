package com.cdp.thread8;

import java.io.File;

import org.apache.log4j.Logger;

public class DirFoldersNumStatisticsOperation extends DirStatisticsOperation {
	private static final Logger LOG = Logger.getLogger(DirFoldersNumStatisticsOperation.class);

	public DirFoldersNumStatisticsOperation(String dirPath) {
		super(dirPath);
	}

	@Override
	public void run() {
		LOG.info("Start counting folders in " + dirPath + " directory.");
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		int folderNum = 0;
		for (File file : files) {
			folderNum += file.isDirectory() ? 1 : 0;
		}
		try {
			Thread.sleep(5500);
			LOG.info("Directory " + dirPath + " contains " + folderNum + " folders.");
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}

}
