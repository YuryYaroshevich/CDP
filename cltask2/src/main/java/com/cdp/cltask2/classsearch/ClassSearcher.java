package com.cdp.cltask2.classsearch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ClassSearcher {
	private static final Logger log = Logger.getLogger(ClassSearcher.class);
	
	public Class<?> findClass(String path, File javaFile) {
		String packageName = path.replace('/', '.');
		String className = packageName + "." + javaFile.getName()
				.substring(0, javaFile.getName().indexOf(".java"));
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			log.error(e);
			throw new RuntimeException(e);
		}
	}
	
	public List<Class<?>> findClasses(String path, File[] javaFiles) {
		List<Class<?>> classes = new ArrayList<>();
		for (File javaFile : javaFiles) {
			classes.add(findClass(path, javaFile));
		}
		return classes;
	}
}
