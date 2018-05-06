package com.patrick.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.patrick.util.FileBrowserUtil;

@Named
@SessionScoped
public class FileBrowserBean implements Serializable {
	private static final long serialVersionUID = -5315513115325350496L;
	private List<String> filePaths = new ArrayList<>();
	private String mostRecentFilePath;
	private FileBrowserUtil fbUtil;
	
	public List<String> getFilePaths() {
		return filePaths;
	}
	public void setFilePaths(List<String> filePaths) {
		this.filePaths = filePaths;
	}
	public String getMostRecentFilePath() {
		return mostRecentFilePath;
	}
	public void setMostRecentFilePath(String mostRecentFilePath) {
		this.mostRecentFilePath = mostRecentFilePath;
		filePaths.add(mostRecentFilePath);
		fbUtil = new FileBrowserUtil(mostRecentFilePath);
	}
	
	
}
