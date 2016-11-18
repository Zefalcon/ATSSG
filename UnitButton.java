package ATSSG;

import ATSSG.Entities.Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;
import ATSSG.Script.ScriptInterface;

public class UnitButton extends Button {
	
	//Variables
	ImageIcon blank = new ImageIcon(UnitType.Void.getImage());
	ScriptInterface si;
	MainMap mainMap;

	//Methods
	public UnitButton(Player owner, MainMap mainMap, ScriptInterface si) {
		super(null, owner);
		this.mainMap = mainMap;
		this.si = si;
	}
	
	public void setEntity(Entity reference) {
		for (ActionListener actlis : gooeyButton.getActionListeners()) {
			gooeyButton.removeActionListener(actlis);
		}
		if (reference == null) {
			gooeyButton.setIcon(blank);
		} else {
			gooeyButton.setIcon(reference.getIcon());
			gooeyButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//if (si.getView().isVisible() == true) {return;}
					//highlight map cell
					//simulate selecting that cell - update dCard
					//simulate selecting that unit - update cCard and highlight in dCard
					mainMap.updateCCard(reference);
				}
			});
		}
	}
	
	public void reset() {
		setEntity(null);
	}
}
