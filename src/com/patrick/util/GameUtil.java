package com.patrick.util;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public class GameUtil implements Serializable {
	private static final long serialVersionUID = 8144476722606795397L;
	private List<String> games = new ArrayList<>();
	private List<String> directories = new ArrayList<>();
	private String gamePath = "F:\\Steam\\steamapps\\common";
	
	public void initializeGamesList() throws IOException {
		Files.walk(Paths.get(gamePath))
		.filter(Files::isRegularFile)
		.forEach(file -> games.add(file.getFileName().toString()));
	}
	
	@PostConstruct
	public void initializeFoldersList() throws IOException {
		Files.walk(Paths.get(gamePath), 1)
		.filter(Files::isDirectory)
		.forEach(directory -> directories.add(directory.getFileName().toString()));
	}
	
	public List<String> getGames() {
		return this.games;
	}
	
	public List<String> getDirectories() {
		return this.directories;
	}
}
