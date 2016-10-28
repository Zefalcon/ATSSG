package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class AttackButton extends CommandButton {

	//Methods
	public AttackButton(Icon icon, String hoverText, Unit unit, Player owner, CommandCard holder) {
		super(icon, hoverText, unit, owner, holder);
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if not left click do nothing
				holder.getParent().setHeldCommand(CommandType.ATTACK);
				holder.getParent().setHeldEntity(unit);
			}
		});
	}
	
	public void clicked() {
		
	}
}
