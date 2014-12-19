package com.cdp.thread1;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedFile {
	private File file;

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock readLock = readWriteLock.readLock();
	private final Lock writeLock = readWriteLock.writeLock();

	public SynchronizedFile(String filePath) {
		this.file = new File(filePath);
	}

	public String read(long skipBytes) throws IOException {
		readLock.lock();
		try (InputStream reader = new BufferedInputStream(new FileInputStream(
				file))) {
			reader.skip(skipBytes);
			int len = 0;
			byte[] readBytes = new byte[1024];
			StringBuilder result = new StringBuilder();
			while ((len = reader.read(readBytes)) != -1) {
				result.append(new String(readBytes, 0, len));
			}
			return result.toString();
		} finally {
			readLock.unlock();
		}
	}

	public void write(String data) throws IOException {
		writeLock.lock();
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(file, true)))) {
			out.print(data);
		} finally {
			writeLock.unlock();
		}
	}
}
