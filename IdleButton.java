package ATSSG;

import javax.swing.Icon;

import ATSSG.Player.Player;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;

public class IdleButton extends CommandButton {

	//Methods
	public IdleButton(Icon icon, String hoverText, Unit unit, Player owner) {
		super(icon, hoverText, unit, owner);
	}
	
	public void clicked() {
		
	}
}
