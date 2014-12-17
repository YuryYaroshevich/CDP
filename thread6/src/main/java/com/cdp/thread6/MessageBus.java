package com.cdp.thread6;

import java.util.Set;

public interface MessageBus {
	void push(Topic topic, Message message);
	
	Set<Message> pull(Topic topic);
}
