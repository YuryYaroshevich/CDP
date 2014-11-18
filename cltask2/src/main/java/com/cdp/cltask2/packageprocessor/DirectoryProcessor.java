package com.cdp.cltask2.packageprocessor;

import java.io.File;
import java.io.FilenameFilter;

import com.cdp.cltask2.propertyholder.PropertyHolder;

public class DirectoryProcessor {	
	private static final PropertyHolder propertyHolder = PropertyHolder.getInstance();
	
	public File[] getFileList(final String extension) {
		File dir = new File(propertyHolder.getProperty("dir.dev.functionality"));
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith("." + extension);
			}			
		});
		return files;
	}
}
