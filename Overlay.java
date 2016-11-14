package ATSSG;

import java.util.Collection;

import javax.swing.JOptionPane;

import ATSSG.Player.Player;

public abstract class Overlay extends UIContainer<Object>{
	
	//Variables
	protected boolean visible;
	
	//Methods
	public Overlay(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);
		visible = false;
		view = new JOptionPane();//JFrame has a setAlwaysOnTop method, test if OptionPane has that behavior natively
	}
}
