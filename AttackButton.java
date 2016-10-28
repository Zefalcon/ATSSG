package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import ATSSG.Player.Player;
import ATSSG.Entities.Entity;

public class AttackButton extends CommandButton {

	//Methods
	public AttackButton(Icon icon, String hoverText, Unit unit, Player owner) {
		super(icon, hoverText, unit, owner);
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if not left click do nothing
				holder.setHeldCommand(CommandType.ATTACK);
				holder.setSelectedEntity(unit);
			}
		});
	}
	
	public void clicked() {
		
	}
}
