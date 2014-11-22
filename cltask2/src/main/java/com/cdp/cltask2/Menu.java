package com.cdp.cltask2;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;

import org.apache.log4j.Logger;

import com.cdp.cltask2.classloader.JarClassLoader;
import com.cdp.cltask2.dirprocessor.DirectoryProcessor;
import com.cdp.cltask2.dirprocessor.JarProcessor;

public class Menu {
	static Logger log = Logger.getLogger(Runner.class);
	
	private DirectoryProcessor directoryProcessor = new DirectoryProcessor();
	private JarProcessor jarProcessor = new JarProcessor();
	
	public void start() {
		log.info("Choose jar from the list(enter number). Enter 0 for exit:");
		Scanner scanIn = new Scanner(System.in);
		while (true) {
			File[] jars = directoryProcessor.getFileList("jar");
			showJars(jars);			
			int jarNumber = scanIn.nextInt();
			if (jarNumber == 0) {
				break;
			}
			if (isValidIndex(jars.length, jarNumber)) {
				log.info("Choose class from the list(enter number):");
				File selectedJar = jars[jarNumber - 1];
				List<JarEntry> classes = jarProcessor.getClasses(selectedJar);
				showClasses(classes);		
				scanIn = new Scanner(System.in);
				int classNumber = scanIn.nextInt();
				if (classNumber == 0) {
					break;
				} 
				if (isValidIndex(classes.size(), classNumber)) {
					String classPathInJar = classes.get(classNumber - 1).getName();					
					JarClassLoader classLoader = new JarClassLoader(selectedJar);
					Class<?> clazz = classLoader.loadClass(classPathInJar);
					
					log.info("Loaded class -> " + clazz);	
					try {
						clazz.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					log.info("Invalid class number.");
				}	
			} else {				
				log.info("Invalid jar number.");
			}	
		}
	}
	
	private boolean isValidIndex(int length, int i) {
		return 1 <= i && i <= length;
	}
	
	private void showJars(File[] jars) {
		for (int i = 0; i < jars.length; i++) {
			log.info((i+1) + ". " + jars[i].getName());
		}
	}
	
	private void showClasses(List<JarEntry> classes) {
		for (int i = 0; i < classes.size(); i++) {
			log.info((i+1) + ". " + classes.get(i).getName());
		}
	}
}
