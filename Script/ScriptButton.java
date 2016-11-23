package ATSSG.Script;

import javax.swing.*;
import ATSSG.Actions.Action;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import ATSSG.Actions.*;

import java.nio.file.Paths;

public class ScriptButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//protected JList<?> options;
	protected DefaultListModel<Action> options;

	//Methods
	public ScriptButton(Icon icon) {
		super(icon);
		//gooeyButton = new JButton(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString()));
		//I am not sure why you take an icon and reset it to blank so I commented out this line during the GUIR update.
		//If you do want that blank, put the ImageIcon constructor in the super call
		testPopulate();
	}

	public DefaultListModel<Action> getOptions(){ //flag change to multiple subclasses?
		return options;
	}

	public void testPopulate(){ //Populates model with options for easier testing; flag to remove later.
		options.addElement(new AttackAction(1, null, null));
		options.addElement(new MoveAction(1, null, null));
	}
}