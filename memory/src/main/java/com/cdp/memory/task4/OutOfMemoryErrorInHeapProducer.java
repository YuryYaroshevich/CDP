package com.cdp.memory.task4;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorInHeapProducer {
	public static void main(String[] args) {
		List<long[]> list = new ArrayList<>();
		while (true) {
			list.add(new long[123456789]);
		}
	}
}
