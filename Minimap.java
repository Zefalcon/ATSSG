package ATSSG;

import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ATSSG.Player.Player;

public class Minimap extends UIContainer<Cell> {
	
	//Fields
	
	//Constructors
	
	public Minimap(Collection<Cell> content, int width, int height, Player owner) {
		super(content, width, height, owner);
		view = new JPanel();
		view.add(new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/BigBlankLabel.png").toString())));
		//view.setBounds(xLoc, yLoc, width, height);
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	//Methods
	

}
