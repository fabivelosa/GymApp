package com.ait.gym.bean;

public class Video {

	private String path;
	private String description;
	private String title;

	public Video(String path, String description, String title) {
		super();
		this.path = path;
		this.description = description;
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
