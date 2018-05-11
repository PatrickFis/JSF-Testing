package com.patrick.designpatterns.util;

public class DecoratorLoggingImpl implements DecoratorLoggingInterface {
	
	public DecoratorLoggingImpl() {
		// Inject me
	}
	
	@Override
	public void log(String message) {
		System.out.println(message);
	}

	@Override
	public void debug(String message) {
		System.out.println(message);
	}

}
