package com.patrick.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.util.GameUtil;

@Named
@SessionScoped
public class HomeBean implements Serializable {
	private static final long serialVersionUID = -5451173758940615448L;
	private String testValue = "test value";
	private Date currentDate = new Date();
	private static final Logger log = Logger.getLogger("homeBean");
	
	@Inject
	private GameUtil gameUtil;
	
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
	
	public List<String> getGamesList() {
		return this.gameUtil.getGames();
	}
	
	public List<String> getGameFolders() {
		return this.gameUtil.getDirectories();
	}
}
