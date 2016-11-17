package ATSSG;

import java.util.Collection;

import javax.swing.JFrame;

import ATSSG.Player.Player;

public abstract class Overlay extends UIContainer<Object>{
	
	//Variables
	
	//Methods
	public Overlay(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		view = frame;
	}
	
	public void setVisible() {
		view.setVisible(true);
	}
}
