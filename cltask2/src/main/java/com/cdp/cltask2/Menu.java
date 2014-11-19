package com.cdp.cltask2;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cdp.cltask2.classsearch.ClassSearcher;
import com.cdp.cltask2.devfunctionality.Batman;
import com.cdp.cltask2.packageprocessor.DirectoryProcessor;
import com.cdp.cltask2.propertyholder.PropertyHolder;

public class Menu {
	static Logger log = Logger.getLogger(Menu.class);
	
	private DirectoryProcessor directoryProcessor = new DirectoryProcessor();
	private ClassSearcher classSearcher = new ClassSearcher();
	
	
	private static final PropertyHolder propertyHolder = PropertyHolder.getInstance(); 
	
	public void start() {
		Batman batman = new Batman();
		batman.saveTheWorld();
		
		log.info("Choose class from the list(enter number):");
		File[] files = directoryProcessor
				.getFileList(propertyHolder.getProperty("project.code.path") 
						+ propertyHolder.getProperty("dev.functionality.path"), "java");
		List<Class<?>> classes = classSearcher.
				findClasses(propertyHolder.getProperty("dev.functionality.path"), files);
		showClassNames(classes);
		Scanner scanIn = new Scanner(System.in);
		int jarNumber = scanIn.nextInt();
		
		
	}	
	
	private void showClassNames(List<Class<?>> classes) {
		int i = 1;
		for (Class<?> clazz : classes) {
			log.info((i) + ". " + clazz.getName());
			i++;
		}
	}
}
