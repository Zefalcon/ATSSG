package ATSSG;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class CommandButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables
	protected String cmdText;
	protected Icon blank;
	
	
	//Methods
	public CommandButton(Icon icon) {
		super(icon);
		//gooeyButton.setBorder(new LineBorder(Color.BLACK));
		this.cmdText = null;
		blank = new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString());
	}
	
	public void setParams(Icon icon, String cmdText, ActionListener actlis) {
		this.cmdText = cmdText;
		this.setIcon(icon);
		for (ActionListener al : this.getActionListeners()) {
			this.removeActionListener(al);
		}
		this.addActionListener(actlis);
	}
	
	public void reset() {
		setParams(blank, "", null);
	}
}
