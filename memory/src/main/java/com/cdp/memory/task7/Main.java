package com.cdp.memory.task7;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final int ARRAY_SIZE = 1048576;

	public static void main(String[] args) {
		List<byte[]> v = new ArrayList<>();
		List<byte[]> deletionList = new ArrayList<>();
		for (int i = 0; ; i++) {
			byte b[] = new byte[ARRAY_SIZE];
			v.add(b);
			deletionList.add(b);
			if (deletionList.size() % 100 == 0) {
				v.removeAll(deletionList);
				deletionList.clear();
			}
			if (i % 10000 == 0) {
				System.out.println("for breakpoint");
			}
		}
	}

}
