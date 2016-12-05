package ATSSG.GUI;

import java.util.Collection;

import javax.swing.JFrame;

public abstract class Overlay extends UIContainer<Object>{
	
	//Variables
	
	//Methods
	public Overlay(Collection<Object> content, int width, int height) {
		super(content, width, height);
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		view = frame;
	}
	
	public void setVisible() {
		view.setVisible(true);
	}
}
