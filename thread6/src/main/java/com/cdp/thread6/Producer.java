package com.cdp.thread6;

import java.util.Random;

import org.apache.log4j.Logger;

public class Producer implements Runnable {
	private MessageBus bus;
	private Random random = new Random();
	
	private static final Logger LOG = Logger.getLogger(Producer.class);

	public Producer(MessageBus bus) {
		this.bus = bus;
	}

	@Override
	public void run() {
		while (true) {
			Topic topic = new Topic(String.valueOf(random.nextInt(3)));
			Message message = new Message(topic.getName() + random.nextDouble());
			bus.push(topic, message);
			LOG.info("push topic = " + topic.getName()
					+ ", message = " + message.getData());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
