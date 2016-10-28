package ATSSG;
import ATSSG.Entities.Unit;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class UnitButton extends Button {
	
	//Variables
	protected Icon visual;
	protected Unit reference;

	//Methods
	public UnitButton(Icon icon, Player owner, Unit reference) {
		super(icon, owner);
		this.reference = reference;
	}
}
