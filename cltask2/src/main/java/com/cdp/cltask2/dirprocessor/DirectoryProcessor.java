package com.cdp.cltask2.dirprocessor;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.log4j.Logger;

import com.cdp.cltask2.propertyholder.PropertyHolder;

public class DirectoryProcessor {
	private static final Logger log = Logger.getLogger(DirectoryProcessor.class);
	
	private static final PropertyHolder propertyHolder = PropertyHolder.getInstance();
	
	public File[] getFileList(final String extension) {
		File dir = new File(propertyHolder.getProperty("directory"));
		File[] files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("." + extension);
			}			
		});
		return files;
	}
}
