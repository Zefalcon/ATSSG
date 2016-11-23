package ATSSG;
import ATSSG.Entities.Unit;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UnitQueue extends UIContainer<UnitButton> {
	
	//Variables
	protected Collection<UnitButton> displayedUnits;
	
	//Constructors
	public UnitQueue(Collection<UnitButton> units, int width, int height) {
		super(units, width, height);
		view = new JPanel();
		view.setLayout(new GridLayout(3,1));
		//flag hack lines below for new UI testing (and relevant imports)
		view.add(new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString())));
		view.add(new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoTerrain.png").toString())));
		view.add(new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString())));
		//view.setBounds(xLoc, yLoc, width, height);
		view.setPreferredSize(new Dimension(width, height));
		view.setVisible(true);
		fillDisplayedUnits();
	}
	
	//Methods
	public void addAll() { 
		
	}
	
	public void remove(Unit instructed) {
		
	}
	
	public boolean isEmpty() {
		return content.isEmpty();
	}
	
	private void fillDisplayedUnits() {
		
	}
}
