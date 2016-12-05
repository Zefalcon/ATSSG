package ATSSG.GUI;

import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ATSSG.Cell;

public class Minimap extends UIContainer<Cell> {
	
	//Fields
	
	//Constructors
	
	public Minimap(Collection<Cell> content, int width, int height) {
		super(content, width, height);
		view = new JPanel();
		view.add(new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/BigBlankLabel.png").toString())));
		//view.setBounds(xLoc, yLoc, width, height);
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	//Methods
	

}
