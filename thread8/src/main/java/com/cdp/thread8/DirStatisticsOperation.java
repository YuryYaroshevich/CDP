package com.cdp.thread8;


public abstract class DirStatisticsOperation implements Runnable {
	protected String dirPath;

	public DirStatisticsOperation(String dirPath) {
		this.dirPath = dirPath;
	}
}
