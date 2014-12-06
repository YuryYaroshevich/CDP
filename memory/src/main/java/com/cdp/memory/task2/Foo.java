package com.cdp.memory.task2;

public class Foo {
	/**
	 * The new object is created. Reference which we pass as argument in bar() method
	 * is copied and in the body of method we have new reference to the old object. Then
	 * new object is created. So the old reference passed in method is still referenced
	 * to old object, new reference is referenced to new object.   
	 * 
	 * @param foo
	 */
	public void bar(Foo foo) {
		foo = new Foo();
	}
}
