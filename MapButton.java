package ATSSG;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MapButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables
	
	GlobalMap gmap;
	
	//Constructors
	public MapButton(int width, int height, GlobalMap gmap) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMapButton.png").toString()));
		this.setSize(new Dimension(width, height));
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Spawn the global map overlay
				//Make that another card in the main Gooey CardLayout?
			}
		});
		this.setEnabled(false);
		this.gmap = gmap;
	}
}
