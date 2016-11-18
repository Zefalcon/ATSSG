package ATSSG;

import javax.swing.Icon;
import javax.swing.JButton;

import ATSSG.Player.Player;

public abstract class Button {
	
	//Variables
	
	protected JButton gooeyButton;
	protected Player owner;
	
	//Constructors
	
	public Button(Icon icon, Player owner) {
		this.owner = owner;
		gooeyButton = new JButton(icon);
	}
	
	public Button(String text, Player owner) {
		this.owner = owner;
		gooeyButton = new JButton(text);
	}
	
	//Methods
	
	public JButton getView() {
		return gooeyButton;
	}
}
