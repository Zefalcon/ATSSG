package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;
import ATSSG.Entities.Entity; //inconsistent with other cmdbuttons

public class AttackButton extends CommandButton {

	//Methods
	public AttackButton(final Entity unit, Player owner) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoAttack.png").toString()),
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