package com.patrick.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PollTestBean implements Serializable {
	private static final long serialVersionUID = -6108082411887700434L;
	private int counter = 0;
	
	public int getCounter() {
		return this.counter;
	}
	
	public void incrementCounter() {
		this.counter++;
	}
	
}
