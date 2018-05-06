package com.patrick.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

@Named
@SessionScoped
public class TagCloudTestBean implements Serializable {

	private static final long serialVersionUID = 2136050773967700266L;
	private TagCloudModel model;
	private String tagCloudLabel;
	private int tagCloudNum;
	
	@PostConstruct
	public void init() {
		model = new DefaultTagCloudModel();
	}

	public TagCloudModel getModel() {
		return model;
	}

	public void onSelect(SelectEvent event) {
		TagCloudItem item = (TagCloudItem) event.getObject();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String getTagCloudLabel() {
		return tagCloudLabel;
	}

	public void setTagCloudLabel(String tagCloudLabel) {
		this.tagCloudLabel = tagCloudLabel;
	}

	public int getTagCloudNum() {
		return tagCloudNum;
	}

	public void setTagCloudNum(int tagCloudNum) {
		this.tagCloudNum = tagCloudNum;
	}
	
	public void updateTagCloud() {
		if(tagCloudLabel != null) {
			model.addTag(new DefaultTagCloudItem(tagCloudLabel, tagCloudNum));
		}
	}
}
