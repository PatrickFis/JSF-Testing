package com.patrick.beans;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.patrick.util.FileBrowserUtil;

@Named
@SessionScoped
public class FileBrowserBean implements Serializable {
	private static final long serialVersionUID = -5315513115325350496L;
	private String mostRecentFilePath;
	private FileBrowserUtil fbUtil;
	private List<Path> filePaths;
	
	public List<Path> getFilePaths() {
		return filePaths;
	}
	public void setFilePaths(List<Path> filePaths) {
		this.filePaths = filePaths;
	}
	public String getMostRecentFilePath() {
		return mostRecentFilePath;
	}
	public void setMostRecentFilePath(String mostRecentFilePath) {
		this.mostRecentFilePath = mostRecentFilePath;
		fbUtil = new FileBrowserUtil(mostRecentFilePath);
		this.filePaths = fbUtil.getFilePaths();
	}
	
	
}
