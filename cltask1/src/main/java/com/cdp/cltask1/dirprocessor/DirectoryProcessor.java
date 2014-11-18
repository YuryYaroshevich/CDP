package com.cdp.cltask1.dirprocessor;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

import com.cdp.cltask1.propertyholder.PropertyHolder;

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
