package com.cdp.memory.task4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class OutOfMemoryErrorInPermGenProducer {
	private static CustomClassLoader classLoader = new CustomClassLoader();
	
	public static void main(String[] args) throws IOException {
		Class<?> clazz = OutOfMemoryErrorInPermGenProducer.class;
		String oldClassName = clazz.getSimpleName();
		String classPath = clazz.getName().replace('.', '/') + ".class";
		byte[] classBytes = getClassBytes(clazz, classPath);
		
		for (int i = 1; ; i++) {				
            String newClassName = generateNewClassName(oldClassName, i);                    
			byte[] newClassBytes = new String(classBytes, "latin1")
			     .replaceAll(oldClassName, newClassName).getBytes("latin1");
			String newCanonicalClassName = clazz.getName().replace(oldClassName, newClassName);
			classLoader.defineClass(newClassBytes, newCanonicalClassName);
		}
	}
	
	private static String generateNewClassName(String oldClassName, int i) {
		/* I don't understand why class name should be formed like this. 
		 * When tried to use names like class1, class2 it throwed exception.
		 * I copy-pasted this from webinar. */
		return "_" + String.format("%0"
                + (oldClassName.length() - 1) + "d", i);
	}
	
	private static byte[] getClassBytes(Class<?> clazz, String classPath) throws IOException {
		InputStream inputStream = clazz
				.getClassLoader().getResourceAsStream(classPath);
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		int i;
		while ((i = inputStream.read(buffer)) >= 0) {
			byteStream.write(buffer, 0, i);
		}
		return byteStream.toByteArray();
	}
}
