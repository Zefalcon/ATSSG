package ATSSG;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ATSSG.Entities.Entity;
import ATSSG.Player.Player;

public class DetailCard extends UIContainer<Entity> {
	
	//Variables
	protected MainMap holder;
	protected TerrainType terrain;
	//protected JPanel terrView;
	//protected JLabel terrPic;
	//protected JLabel terrDescript;
	//protected JPanel entView;
	//protected Dimension terrSize;
	//protected Dimension entSize;
	//protected GridLayout entGrid;
	
	protected EntityCard entCard;
	
	//Constructors
	public DetailCard(Collection<Entity> occupiers, TerrainType terrain, final int width, final int height, 
			final Player owner, final MainMap holder) {
		super(occupiers, width, height, owner);
		/*this.terrain = terrain;
		this.holder = holder;
		terrSize = new Dimension(height / 2, height);
		entSize = new Dimension(width - height / 2, height);
		if (content == null) {content = new ArrayList<Entity>(0);}
		entGrid = new GridLayout(2, 12);
		
		terrView = new JPanel();
		terrView.setLayout(new GridLayout(2, 1));
		//terrView.setMaximumSize(terrSize); //Flag it was this line that when introduced put terrain descriptions offscreen
		//terrView.setMinimumSize(terrSize);
		terrPic = new JLabel(TerrainType.VOID.getImage());
		terrView.add(terrPic);
		terrDescript = new JLabel(TerrainType.VOID.getDescription());
		terrView.add(terrDescript);
		
		entView = new JPanel();
		entView.setLayout(entGrid);
		for (int b = 0; b < 24; b++) {
			entView.add(new JLabel(UnitType.Soldier.getImage())); //Flag this is a generic button but eventually must be a UnitButton
		}
		entView.setMaximumSize(entSize);
		entView.setMinimumSize(entSize);*/
		
		view = new JPanel();
		//view.add(terrView);
		//view.add(entView);
		view.setPreferredSize(getSize());
		entCard = new EntityCard(occupiers, 3 * width / 4, height, owner, holder);
		view.add(entCard.getView()); //Flag test code
		//terrView.setVisible(true);
		//entView.setVisible(true);
		view.setVisible(true);
	}
	
	//Methods
	
	//This update is called by turn ending functionality, just in case the units you selected die horribly. Or a nuke changes the terrain. Whichever.
	public void update() {
		update(content, terrain);
	}
	
	public void update(Collection<Entity> occupiers, TerrainType terrain) {
		/*view.remove(terrView);
		view.remove(entView);
		
		if (occupiers == null) {content = new ArrayList<Entity>(0);}
		else {this.content = occupiers;}
		this.terrain = terrain;
		
		terrPic.setIcon(terrain.getImage());
		terrDescript.setText(terrain.getDescription());
		terrView = new JPanel();
		terrView.setLayout(new GridLayout(2, 1));
		terrView.setMaximumSize(terrSize); //Flag it was this line that when introduced put terrain descriptions offscreen
		terrView.setMinimumSize(terrSize);
		terrView.add(terrPic);
		terrView.add(terrDescript);
		terrView.setVisible(true);
		
		entView = new JPanel();
		entView.setLayout(entGrid);
		int numEnts = 0;
		for (Entity e : occupiers) {
			JButton jb = e.getButton().getGooey();
			jb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//FLAG Need gooeyButton field (from Button) to hold a reference to the unit, either through modifying 
					//GooeyJButton or another such extension of JButton.
					//I.E. the UnitButton constructor must set gooeyButton to something that is not a standard JButton
					//Note also this is where we need the passed-in reference to MainMap
				}
			});
			entView.add(jb);
			numEnts++; //Flag possible abberance: DetailCard is not protected from cells with more units than it is meant to display
		}
		while (numEnts < 24) {
			entView.add(new JLabel(/*UnitType.Void.getImage()*//*|||new ImageIcon(Paths.get("src/ATSSG/Art/DemoMove.png").toString())));
			numEnts++;
		}
		
		//when you add a UnitButton, add an actionlistener to it. Since that actlis requires a reference to MainMap, 
		//it cannot be created outside the UI hierarchy because no one likes hideously intercoupled structures
		//Copy this behavior to UnitQueue eventually.
		
		view.add(terrView);
		view.add(entView);
		terrView.setPreferredSize(terrSize);
		entView.setPreferredSize(entSize);
		
		terrView.setVisible(true);
		entView.setVisible(true);*/
		content = occupiers;
		entCard.update(content);
		
	}
}
