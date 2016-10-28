package ATSSG;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class IdleButton extends CommandButton {

	//Methods
	public IdleButton(Icon icon, String hoverText, Unit unit, Player owner, CommandCard holder) {
		super(icon, hoverText, unit, owner, holder);
	}
	
	public void clicked() {
		
	}
}
