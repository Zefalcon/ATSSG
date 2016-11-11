package ATSSG;

import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Player.Player;

public class ScriptButton extends Button {

	//Methods
	public ScriptButton(Player owner) {
		super(null , owner);
		gooeyButton = new JButton(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString()));
	}
}
