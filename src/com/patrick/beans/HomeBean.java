package com.patrick.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped

public class HomeBean implements Serializable {
	private static final long serialVersionUID = -5451173758940615448L;
	private String testValue = "test value";
	private Date currentDate = new Date();
	private static final Logger log = Logger.getLogger("homeBean");
	
	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
	public void refreshCurrentDate() {
		log.info("refreshCurrentDate() called");
		this.currentDate = new Date();
	}
	
	public String getTestValue() {
		return this.testValue;
	}
	
	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}
}
