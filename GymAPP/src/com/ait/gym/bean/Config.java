package com.ait.gym.bean;

import java.io.File;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.util.http.fileupload.FileUtils;

@WebListener
public class Config implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent event) {
		deleteUploadedFiles();
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
	
	private void deleteUploadedFiles() {
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		File directoryPath = new File(servletContext.getRealPath("") + File.separator + "resources" + File.separator + "uploadedVideos");
		try {
			FileUtils.cleanDirectory(directoryPath);
		} catch (IOException e) {
			System.out.println("Exception Occurred while deleting files");
		}
	}

}