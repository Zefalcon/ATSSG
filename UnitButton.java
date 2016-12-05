package ATSSG;

import ATSSG.Entities.Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Script.ScriptInterface;

public class UnitButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables
	protected static ImageIcon blank = new ImageIcon(UnitType.resizeCard(UnitType.Void.getImage()));
	protected ScriptInterface si;
	protected MainMap mainMap;

	//Methods
	public UnitButton( MainMap mainMap, ScriptInterface si) {
		super(blank);
		this.mainMap = mainMap;
		this.si = si;
	}
	
	public void setEntity(final Entity reference) {
		for (ActionListener actlis : this.getActionListeners()) {
			this.removeActionListener(actlis);
		}
		if (reference == null) {
			this.setIcon(blank);
		} else {
			this.setIcon(reference.getCardIcon());
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (si.isVisible() == true) {return;}
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
