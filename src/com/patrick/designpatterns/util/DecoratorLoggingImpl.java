package com.patrick.designpatterns.util;

public class DecoratorLoggingImpl implements DecoratorLoggingInterface {
	
	@Override
	public void log(String message) {
		System.out.println(message);
	}

	@Override
	public void debug(String message) {
		System.out.println(message);
	}

}
