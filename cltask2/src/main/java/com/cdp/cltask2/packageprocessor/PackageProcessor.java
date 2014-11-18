package com.cdp.cltask2.packageprocessor;

import java.util.Set;

import org.reflections.Reflections;

public class PackageProcessor {
	public Set<Class<?>> listClasses(String packageName) {
		Reflections reflections = new Reflections(packageName);
		return reflections.getSubTypesOf(Object.class);
	}
}
