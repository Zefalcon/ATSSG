package ATSSG.GUI;

import ATSSG.Cell;
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
	protected UIContainer<?> holder;

	//Methods
	public UnitButton(MainMap mainMap, ScriptInterface si, UIContainer<?> holder) {
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
			this.setToolTipText(null);
		} else {
			reference.updateHealthyImage();
			this.setIcon(new ImageIcon(reference.getHealthyImage()));
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (si.isVisible() == true) {return;}
					//update dCard
					if (holder instanceof EntityCard) {
						((EntityCard) holder).removeBorders();
					} else if (holder instanceof UnitQueue) {
						((UnitQueue) holder).removeBorders();
						//also recenter map
						Cell loc = reference.getContainingCell();
						int xLoc = loc.getX() - mainMap.getCameraWidth() / 2;
						int yLoc = loc.getY() - mainMap.getCameraHeight() / 2;
						mainMap.updateView(xLoc, yLoc);
						//and highlight on MainMap and in EntityCard
						
						//Also figure out how to link 'giving orders' to 'removal' from this, then this is done.
					} else {
						System.out.println("How did you get here?");
					}
					setBorderPainted(true);
					//update cCard
					mainMap.updateCCard(reference);
				}
			});
			this.setToolTipText(reference.toString());
		}
	}
	
	public void reset() {
		setEntity(null);
	}
}
