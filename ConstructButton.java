package ATSSG;

import javax.swing.Icon;

import ATSSG.Player.Player;
import ATSSG.Entities.Entity; //Inconsistent with other cmdbuttons

public class ConstructButton extends CommandButton {

	//Methods
	public ConstructButton(Icon icon, String hoverText, Entity unit, Player owner) {
		super(icon, hoverText, unit, owner);
	}
	
	public void clicked() {
		
	}
}