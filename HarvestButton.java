package ATSSG;

import javax.swing.Icon;

import ATSSG.Player.Player;
import ATSSG.Entities.Entity;

public class HarvestButton extends CommandButton {

	//Methods
	public HarvestButton(Icon icon, String hoverText, Unit unit, Player owner, MainMap holder) {
		super(icon, hoverText, unit, owner);
	}
	
	public void clicked() {
		
	}
}
