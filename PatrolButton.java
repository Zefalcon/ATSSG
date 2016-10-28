package ATSSG;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class PatrolButton extends CommandButton {

	//Methods
	public PatrolButton(Icon icon, String hoverText, Unit unit, Player owner, CommandCard holder) {
		super(icon, hoverText, unit, owner, holder);
	}
	
	public void clicked() {
		
	}
}
