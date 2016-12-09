package ATSSG.GUI;

import ATSSG.Entities.Entity;
import ATSSG.Enums.UnitType;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

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
	protected EntityCard holder;

	//Methods
	public UnitButton(MainMap mainMap, ScriptInterface si, EntityCard holder) {
		super(blank);
		this.mainMap = mainMap;
		this.si = si;
		this.holder = holder;
		setBorder(new LineBorder(Color.BLACK, 2));
		setBorderPainted(false);
	}
	
	public void setEntity(final Entity reference) {
		for (ActionListener actlis : this.getActionListeners()) {
			this.removeActionListener(actlis);
		}
		if (reference == null) {
			this.setIcon(blank);
		} else {
			reference.updateHealthyImage();
			this.setIcon(new ImageIcon(reference.getHealthyImage()));
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (si.isVisible() == true) {return;}
					//update dCard
					holder.removeBorders();
					setBorderPainted(true);
					//update cCard
					mainMap.updateCCard(reference);
				}
			});
		}
	}
	
	public void reset() {
		setEntity(null);
	}
}
