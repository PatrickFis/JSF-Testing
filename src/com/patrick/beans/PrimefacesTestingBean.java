package com.patrick.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

import com.patrick.util.GameUtil;

@Named
public class PrimefacesTestingBean implements Serializable {

	private static final long serialVersionUID = -6972070299056576097L;

	private MindmapNode root;
	private MindmapNode selectedNode;

	private GameUtil gameUtil = new GameUtil();
	
	public PrimefacesTestingBean() throws IOException {
		gameUtil.initializeFoldersList();
		root = new DefaultMindmapNode("Games!", "Lots o' Games", "FFCC00", false);
		for (String game : gameUtil.getDirectories()) {
			MindmapNode gameNode = new DefaultMindmapNode(game, "Game Title", "6e9ebf", true);
			root.addNode(gameNode);
		}
	}

    public MindmapNode getRoot() {
        return root;
    }
 
    public MindmapNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }

	public void onNodeSelect(SelectEvent event) {
		MindmapNode node = (MindmapNode) event.getObject();
	}

	public void onNodeDblselect(SelectEvent event) {
		this.selectedNode = (MindmapNode) event.getObject();
	}
	
	public List<String> getGamesList() {
		return this.gameUtil.getGames();
	}
	
	public List<String> getGameFolders() {
		return this.gameUtil.getDirectories();
	}
}
