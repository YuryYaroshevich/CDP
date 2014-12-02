package com.cdp.memory.task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * I modified this class a little bit to make it possible
 * to set breakpoint before explosion and have opportunity
 * to see free heap memory by using visualvm.
 * 
 * To run this code I used jvm config: 
 * -XX:ThreadStackSize=2m -Xmx1024m -XX:SurvivorRatio=5  -Xshare:off
 * 
 * @author dirtyyura007
 */
public class MemoryEater {
	private static final int ARRAY_SIZE = 1048576;
	
	public static void main(String[] args) throws IOException {
		List v = new ArrayList();
		while (true) {
			byte b[] = new byte[ARRAY_SIZE];
			//In the task there is a note: "change the code so that fix it".
			// I can comment this line and there will be no OutOfMemoryError.
			v.add(b);
			Runtime rt = Runtime.getRuntime();
			if (rt.freeMemory() < ARRAY_SIZE) {
				System.out.println("free memory: " + rt.freeMemory());	
			}
		}
	}
}
