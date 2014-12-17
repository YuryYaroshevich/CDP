package com.cdp.thread6;

import java.util.Set;

import com.google.common.collect.HashMultimap;

public class AsynchronousMessageBus implements MessageBus {
	private HashMultimap<Topic, Message> bus;
	private Topic requestedTopic;
	
	public AsynchronousMessageBus(int expectedKeys, int expectedValuesPerKey) {
		bus = HashMultimap.create(expectedKeys, expectedValuesPerKey);
	}
	
	@Override
	public void push(Topic topic, Message message) {
		synchronized (bus) {
			bus.put(topic, message);
			if (topic.equals(requestedTopic)) {
				bus.notify();
				requestedTopic = null;
			}
		}
	}

	@Override
	public Set<Message> pull(Topic topic) {
		try {
			requestedTopic = topic;
			synchronized (bus) {
				if (!bus.containsKey(topic)) { 
					bus.wait();
				}
				return bus.removeAll(topic);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
