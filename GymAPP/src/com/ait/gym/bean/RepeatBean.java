package com.ait.gym.bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean
@RequestScoped
public class RepeatBean {

	private final long serialVersionUID = 1L;
	private ArrayList<Video> videos;

	@PostConstruct
	public void init() {
		videos = new ArrayList<Video>();
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		File directoryPath = new File(servletContext.getRealPath("") + File.separator + "resources" + File.separator + "uploadedVideos");
        //List of all files and directories
	    String contents[] = directoryPath.list();
	    System.out.println("List of files and directories in the specified directory:");
	     for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	         String path = "/GymAPP/javax.faces.resource/uploadedVideos/"+File.separator+contents[i]+".xhtml";
	         String title =  contents[i].substring(0,contents[i].indexOf("$"));
	         String description = contents[i].substring(contents[i].indexOf("$")+1,contents[i].indexOf("."));
	         videos.add(new Video(path,description ,title));
	      }	
	}

	public ArrayList<Video> getVideos() {
		return videos;
	}

	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}

}
