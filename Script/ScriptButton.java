package ATSSG.Script;

import javax.swing.*;
import ATSSG.Actions.Action;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import ATSSG.Actions.*;
import ATSSG.Button;
import ATSSG.Player.Player;

import java.nio.file.Paths;

public class ScriptButton extends Button {

	//protected JList<?> options;
	protected DefaultListModel<Action> options;

	//Methods
	public ScriptButton(Icon icon, Player player) {
		super(icon, player);
		gooeyButton = new JButton(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString()));
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
