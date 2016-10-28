package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;
import ATSSG.Entities.Entity; //inconsistent with other cmdbuttons

public class AttackButton extends CommandButton {

	//Methods
	public AttackButton(final Entity unit, Player owner) {
		super(new ImageIcon("D:/James/Documents/Eclipse/Workspace/ATSSG/src/ATSSG/Art/DemoAttack.png"),
				"Attack Command Hover Text", unit, owner);
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if not left click do nothing
				holder.setHeldCommand(CommandType.ATTACK);
				holder.setHeldEntity(unit);
			}
		});
	}
	
	public void clicked() {
		
	}
}