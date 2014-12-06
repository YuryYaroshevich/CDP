package com.cdp.memory.task4;

public class CustomClassLoader extends ClassLoader {
	public Class<?> defineClass(byte[] classBytes, String className) {
		return super.defineClass(className, classBytes, 0, classBytes.length);
	}
}
