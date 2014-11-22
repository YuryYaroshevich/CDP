package com.cdp.cltask3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

public class CustomClassLoader extends ClassLoader {
	protected static final Logger log = Logger.getLogger(CustomClassLoader.class);
	
	private StatusOutputThread statusOutputThread = new StatusOutputThread(
			"Start loading...", "Loading finished.");
	
	@Override 
	protected Class<?> findClass(String classPath) {
		statusOutputThread.start();
		Path path = Paths.get(classPath);
		try {
			byte[] classBytes = Files.readAllBytes(path);
			Class<?> clazz = defineClass(extractClassName(classPath),
					classBytes, 0, classBytes.length);		
     		return clazz;
		} catch (IOException e) {
			log.error("Error occured", e);
			throw new RuntimeException(e);
		} finally {
			statusOutputThread.stopOutput();
		}
	}
	
	
	
	private String extractClassName(String classPath) {
		return "com.epam.mentoring.lesson." + classPath.substring(classPath.lastIndexOf('/') + 1,
				classPath.indexOf(".class"));
	}
}
