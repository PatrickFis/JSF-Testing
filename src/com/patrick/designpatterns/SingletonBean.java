package com.patrick.designpatterns;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.ejb.Singleton;

@Singleton
public class SingletonBean {
	
	private Queue<Object> pool = new LinkedBlockingQueue<>(1000);
	
	public SingletonBean() {
		for(int i = 0; i < 1000; i++) {
			pool.offer(i);
		}
	}
	
	public Queue<Object> getPool() {
		return pool;
	}
}
