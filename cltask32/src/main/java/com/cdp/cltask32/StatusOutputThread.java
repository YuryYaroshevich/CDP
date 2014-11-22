package com.cdp.cltask32;

import org.apache.log4j.Logger;

public class StatusOutputThread extends Thread {
	private static final Logger log = Logger.getLogger(StatusOutputThread.class);
	
	private boolean working = true;
	
	private String startMessage;
	private String lastMessage;
	
	public StatusOutputThread(String startMessage, String lastMessage) {
		this.startMessage = startMessage;
		this.lastMessage = lastMessage;
	}

	@Override
	public void run() {	
		try {
			log.info(startMessage);
			while (working) {
				log.info("In progress...");
			}		
			log.info(lastMessage);				
		} finally {
		}
	}
	
	public synchronized void stopOutput() {
		this.working = false;
	}
}
