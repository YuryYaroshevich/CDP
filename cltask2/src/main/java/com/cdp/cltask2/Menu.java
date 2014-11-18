package com.cdp.cltask2;

import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.cdp.cltask2.devfunctionality.Batman;
import com.cdp.cltask2.packageprocessor.PackageProcessor;
import com.cdp.cltask2.propertyholder.PropertyHolder;

public class Menu {
	static Logger log = Logger.getLogger(Menu.class);
	
	private PackageProcessor packageProcessor = new PackageProcessor();
	
	private static final PropertyHolder propertyHolder = PropertyHolder.getInstance(); 
	
	public void start() {
		Batman batman = new Batman();
		batman.saveTheWorld();
		log.info(Batman.class.getCanonicalName());
		
		log.info("Choose class from the list(enter number):");
		Set<Class<?>> classes = packageProcessor
				.listClasses(propertyHolder.getProperty("package.dev.functionality"));
		showClassNames(classes);
		Scanner scanIn = new Scanner(System.in);
		int jarNumber = scanIn.nextInt();
		
		
	}	
	
	private void showClassNames(Set<Class<?>> classes) {
		int i = 1;
		for (Class<?> clazz : classes) {
			log.info((i) + ". " + clazz.getCanonicalName());
			i++;
		}
	}
}
