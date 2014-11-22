package com.cdp.cltask3;


public class App {
	private MethodInvoker methodInvoker = new MethodInvoker();
	
	public void start(String classPath) {
		try {
			ClassLoader classLoader = new CustomClassLoader();
			Class<?> clazz = classLoader.loadClass(classPath);
			Object o = clazz.newInstance();
			
			methodInvoker.invoke(o, "saveTheWorld");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
