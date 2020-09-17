package com.ait.gym.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.FileUploadMBean;

class FileUploadMBeanTest {
	
	private FileUploadMBean myFileUploadMBean;
	
	@BeforeEach
    public void setUp() {
		myFileUploadMBean = new FileUploadMBean ();
    }
	
	@Test
	void testSetName() {
		myFileUploadMBean.setName("Path");
		assertEquals("Path", myFileUploadMBean.getName());
	}
	@Test
	void testSetTitle() {
		myFileUploadMBean.setTitle("Abs workout");
		assertEquals("Abs workout", myFileUploadMBean.getTitle());
	}
	@Test
	void testSetMessage() {
		myFileUploadMBean.setMessage("Warm up tutorial");
		assertEquals("Warm up tutorial", myFileUploadMBean.getMessage());
	}
	
	
}
