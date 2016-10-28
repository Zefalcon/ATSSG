package ATSSG;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Player.Player;

public abstract class Button {
	
	//Variables
	
	JButton gooeyButton;
	Player owner;
	
	//Constructors
	
	public Button(Icon icon, Player owner) {
		this.owner = owner;
		gooeyButton = new JButton(icon);
	}
	
	//Methods
	
	public JButton getGooey() {
		return gooeyButton;
	}
}
