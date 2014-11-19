package com.cdp.cltask2.packageprocessor;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryProcessor {	
	public File[] getFileList(String path, final String extension) {
		File dir = new File(path);		
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith("." + extension);
			}			
		});
		return files;
	}
}
