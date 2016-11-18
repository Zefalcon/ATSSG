package ATSSG;

import java.awt.event.ActionListener;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class MenuElement extends Button {

	public MenuElement(Icon icon, Player owner, ActionListener actlis) {
		super(icon, owner);
		gooeyButton.addActionListener(actlis);
	}
	
	public MenuElement(String text, Player owner, ActionListener actlis) {
		super(text, owner);
		gooeyButton.addActionListener(actlis);
	}
}
