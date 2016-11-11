package ATSSG;

import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Player.Player;

public class MenuButton extends Button {

	public MenuButton(Player owner) {
		super(null, owner);
		gooeyButton = new JButton(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString()));
	}
	
	public void clicked() {
		
	}
}
