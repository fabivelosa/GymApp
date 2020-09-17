package com.ait.gym.bean;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

@ManagedBean
@ViewScoped
public class FileUploadMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Part file1;
	private String message;
	private String name;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Part getFile1() {
		return file1;
	}
	public void setFile1(Part file1) {
		this.file1 = file1;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String uploadFile() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		String fileName = "uploadedVideos"+File.separator + title + "$" + name + ".mp4"; 
		Path copied = Paths.get(servletContext.getRealPath("") + File.separator + "resources" + File.separator + fileName);
	    Files.copy(file1.getInputStream(), copied, StandardCopyOption.REPLACE_EXISTING);
		return null;
	}
}