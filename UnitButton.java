package ATSSG;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class UnitButton extends Button {
	
	//Variables

	//Methods
	public UnitButton(Player owner, MainMap mainMap) {
		super(null, owner);
	}
	
	public void setEntity(Entity reference) {
		for (ActionListener actlis : gooeyButton.getActionListeners()) {
			gooeyButton.removeActionListener(actlis);
		}
		if (reference == null) {
			gooeyButton.setIcon(UnitType.Void.image);
		} else {
			gooeyButton.setIcon(reference.getImage());
			gooeyButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//highlight map cell
					//simulate selecting that cell - update dCard
					//simulate selecting that unit - update cCard and highlight in dCard
				}
			});
		}
	}
	
	public void reset() {
		setEntity(null);
	}
}
