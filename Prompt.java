package ATSSG;

import java.util.Collection;

import javax.swing.JOptionPane;

import ATSSG.Player.Player;

public class Prompt extends Overlay {
	
	//Variables
	protected String message;
	protected Button goTo;

	//Methods
	public Prompt(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);
		//view = new JOptionPane();
		//Given how JOptionPane actually works this class is likely redundant and destined for purging.
	}
}
