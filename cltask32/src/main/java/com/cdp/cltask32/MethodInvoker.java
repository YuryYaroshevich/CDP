package com.cdp.cltask32;

import java.lang.reflect.Method;
import java.util.Set;

import static org.reflections.ReflectionUtils.*;

public class MethodInvoker {
	public void invoke(Object o, String methodName, Object ...args) {
		try {
			Set<Method> methods = getAllMethods(o.getClass(), withName(methodName));
			Method method = methods.iterator().next();
			method.invoke(o, args);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
