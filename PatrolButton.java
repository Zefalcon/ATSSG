package ATSSG;

import javax.swing.Icon;

import ATSSG.Player.Player;
import ATSSG.Entities.Unit;

public class PatrolButton extends CommandButton {

	//Methods
	public PatrolButton(Icon icon, String hoverText, Unit unit, Player owner) {
		super(icon, hoverText, unit, owner);
	}
	
	public void clicked() {
		
	}
}