package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Player.Player;

public class MapButton extends Button {

	//Fields
	
	GlobalMap gmap;
	
	//Constructors
	public MapButton(Player owner, GlobalMap gmap) {
		super(null, owner);
		this.gooeyButton = new JButton(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString()));
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Spawn the global map overlay
				//Make that another card in the main Gooey CardLayout?
			}
		});
		this.gmap = gmap;
	}
}
