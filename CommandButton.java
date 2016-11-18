package ATSSG;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import ATSSG.Player.Player;

public class CommandButton extends Button {
	
	//Variables
	protected String cmdText;
	protected Icon blank;
	
	
	//Methods
	public CommandButton(Icon icon, Player owner) {
		super("", owner);
		this.gooeyButton = new GooeyJButton(icon, null);
		//gooeyButton.setBorder(new LineBorder(Color.BLACK));
		this.cmdText = null;
		blank = new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString());
	}
	
	public void setParams(Icon icon, String cmdText, ActionListener actlis) {
		this.cmdText = cmdText;
		gooeyButton.setIcon(icon);
		for (ActionListener al : gooeyButton.getActionListeners()) {
			gooeyButton.removeActionListener(al);
		}
		gooeyButton.addActionListener(actlis);
	}
	
	public void reset() {
		setParams(blank, "", null);
	}
}
