package ATSSG.GUI;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import ATSSG.Enums.CommandType;

public class CommandButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables
	
	//Methods
	public CommandButton(Icon icon) {
		super(icon);
	}
	
	public void setParams(CommandType cmdt, ActionListener actlis) {
		this.setToolTipText(cmdt.getName());
		this.setIcon(cmdt.getIcon());
		for (ActionListener al : this.getActionListeners()) {
			this.removeActionListener(al);
		}
		this.addActionListener(actlis);
	}
	
	public void reset() {
		setParams(CommandType.VOID, null);
		this.setToolTipText(null);
	}
}
