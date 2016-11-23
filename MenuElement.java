package ATSSG;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class MenuElement extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables
	
	//Constructors

	public MenuElement(Icon icon, ActionListener actlis) {
		super(icon);
		this.addActionListener(actlis);
	}
	
	public MenuElement(String text, ActionListener actlis) {
		super(text);
		this.addActionListener(actlis);
	}
}
