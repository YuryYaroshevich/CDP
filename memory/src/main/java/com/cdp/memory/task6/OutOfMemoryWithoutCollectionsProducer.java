package com.cdp.memory.task6;


public class OutOfMemoryWithoutCollectionsProducer {
	
	public static void main(String[] args) {
		Node startNode = new Node(null);
		Node nextNode = new Node(startNode);
		while (true) {
			nextNode = new Node(nextNode);
		}
	}
}
