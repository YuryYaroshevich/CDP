package com.cdp.cltask1.classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

import com.cdp.cltask1.dirprocessor.JarProcessor;

public class JarClassLoader {
	private static final Logger log = Logger.getLogger(JarProcessor.class);
	
	private ClassLoader classLoader;
	
	public JarClassLoader(File jar) {
		try {
			this.classLoader = new URLClassLoader(new URL[] {jar.toURI().toURL()});
		} catch (MalformedURLException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public Class<?> loadClass(String classPathInJar) {
		try {
			String className = extractClassName(classPathInJar);
			return classLoader.loadClass(className);
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	private String extractClassName(String classPathInJar) {
		return classPathInJar
				.substring(0, classPathInJar.indexOf(".class"))
				.replace('/', '.');
	}
}
