package com.cdp.cltask1.dirprocessor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

public class JarProcessor {

	private static final Logger log = Logger.getLogger(JarProcessor.class);
	
	public List<JarEntry> getClasses(File file) {
		JarFile jar = null;
		try {
			jar = new JarFile(file);
		} catch (IOException e) {
			log.error("Error occured while openning jar file.", e);
			throw new RuntimeException(e);
		}
		
		Enumeration<JarEntry> files = jar.entries();
		List<JarEntry> classes = new ArrayList<>();
		while (files.hasMoreElements()) {
			JarEntry jarEntry = files.nextElement(); 
			if (jarEntry.getName().endsWith(".class")) {
				classes.add(jarEntry);
			}			
		}
		return classes;
	}

}
