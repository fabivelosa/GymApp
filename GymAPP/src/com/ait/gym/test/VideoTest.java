package com.ait.gym.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.ait.gym.bean.Video;

class VideoTest {
	
private Video myVideo;

	@BeforeEach
    public void setUp() {
		myVideo= new Video("Path","description","title");
    }
	
	@Test
	public void testVideoConstructor() {
		assertEquals("Path", myVideo.getPath());
		assertEquals("description", myVideo.getDescription());
		assertEquals("title", myVideo.getTitle());
	}
	
	@Test
	void testSetPath() {
		myVideo.setPath("Path");
		assertEquals("Path", myVideo.getPath());
	}
	
	@Test
	void testSetDescription() {
		myVideo.setDescription("description");
		assertEquals("description", myVideo.getDescription());
	}
	
	@Test
	void testSetTitle() {
		myVideo.setTitle("title");
		assertEquals("title", myVideo.getTitle());
	}
}
