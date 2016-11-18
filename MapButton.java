package ATSSG;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;

public class MapButton extends Button {

	//Fields
	
	GlobalMap gmap;
	
	//Constructors
	public MapButton(int width, int height, Player owner, GlobalMap gmap) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMapButton.png").toString()), owner);
		gooeyButton.setSize(new Dimension(width, height));
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Spawn the global map overlay
				//Make that another card in the main Gooey CardLayout?
			}
		});
		gooeyButton.setEnabled(false);
		this.gmap = gmap;
	}
}
