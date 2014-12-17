package com.cdp.thread6;

import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

public class Consumer implements Runnable {
	private MessageBus bus;
	private Random random = new Random();

	private static final Logger LOG = Logger.getLogger(Consumer.class);

	public Consumer(MessageBus bus) {
		this.bus = bus;
	}

	@Override
	public void run() {
		while (true) {
			Topic topic = new Topic(String.valueOf(random.nextInt(3)));
			Set<Message> messages = bus.pull(topic);
			for (Message msg : messages) {
				LOG.info("pull topic = " + topic.getName()
						+ " , message = " + msg.getData());
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
