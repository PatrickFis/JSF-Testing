package com.patrick.designpatterns;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;

import com.patrick.designpatterns.util.ObservableClass;

public class Observer {
	
	private static final Logger log = Logger.getLogger("observer");
	
	public void observeEvent(@Observes ObservableClass observableClass) {
		log.log(Level.INFO, "Observed an event of type ObservableClass");
	}
}
