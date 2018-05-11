package com.patrick.designpatterns;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import com.patrick.designpatterns.util.DecoratorLoggingInterface;

@Decorator
public abstract class LoggingDecorator implements DecoratorLoggingInterface {

	private static final Logger log = Logger.getLogger("decorator");
	
	@Any
	@Delegate
	@Inject
	private DecoratorLoggingInterface logger;
	
	@Override
	public void debug(String message) {
		log.log(Level.INFO, "LoggingDecorator debug method called, message: {0}", message);
	}
}
