package ATSSG;
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
import javax.swing.JSplitPane;
import javax.swing.JWindow;

import ATSSG.Entities.Entity;
import ATSSG.Player.Player;

public class DetailCard extends UIContainer<Cell> {
	
	//Variables
	protected MainMap holder;
	protected Collection<Entity> occupiers;
	protected TerrainType[] terrains;
	protected JWindow view;
	protected JPanel terrView;
	protected JPanel entView;
	protected GridLayout terrGrid;
	protected GridLayout entGrid;
	protected ImageIcon blankIcon;
	protected int entX;
	protected int entY;
	protected int entW;
	protected int terrW;
	
	//Constructors
	public DetailCard(Collection<Cell> location, final int xLoc, final int yLoc, final int width, final int height,
			final int displayLevel, final Player owner, final MainMap holder) {
		super(location, xLoc, yLoc, width, height, displayLevel, owner);
		this.holder = holder;
		if (content == null) {occupiers = new ArrayList<Entity>(0);}
		else {occupiers = new ArrayList<Entity>(content.size());}
		blankIcon = new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString());
		terrW = height;
		int numTerr = 1; //flag arbitrary number
		int gridS = (int) Math.ceil(Math.sqrt(numTerr));
		entX = xLoc + terrW;
		entY = yLoc;
		entW = width - terrW;
		terrGrid = new GridLayout(gridS, gridS);
		entGrid = new GridLayout(2, 12); //flag arbitrary numbers
		
		terrView = new JPanel();
		terrView.setLayout(terrGrid);
		for (int a = 0; a < numTerr; a++) {
			terrView.add(new JLabel(blankIcon));
		}
		
		entView = new JPanel();
		entView.setLayout(entGrid); 
		for (int b = 0; b < 24; b++) { //see unitGrid flag
			entView.add(new JLabel(blankIcon));
		}
		
		view = new JWindow();
		view.setLayout(new GridLayout(1, 2));
		view.add(terrView);
		view.add(entView);
		terrView.setBounds(xLoc, yLoc, terrW, height);
		entView.setBounds(entX, entY, entW, height);
		view.setBounds(xLoc, yLoc, width, height);
		
		terrView.setVisible(true);
		entView.setVisible(true);
		view.setVisible(true);
	}
	
	//Methods
	
	//This update is called by turn ending functionality, just in case the units you selected die horribly.
	public void update() {
		update(content);
	}
	
	public void update(Collection<Cell> selection) {
		if (selection == null) {this.content = new ArrayList<Cell>(0);}
		else {this.content = selection;}
		occupiers.clear();
		int[] terrainCounts = new int[5]; //Flag this array needs to be the size of the number of distinct terrain types.
		for (Cell c : content) {
			Collection<Entity> e = c.getOccupyingEntities();
			for (Entity n : e) {
				/*if (n.getOwner() == owner) {*/occupiers.add(n);//}
			}
			terrainCounts[c.getTerrainType().getNumber()]++;
		}
		terrains = highestTerrains(1, terrainCounts); //Flag the int argument will change with DetailCard philosophies
		
		terrView = new JPanel();
		terrView.setLayout(terrGrid);
		for(int f = 0; f < terrains.length; f++) {
			terrView.add(terrains[f].getLabel());
		}
		
		
		entView = new JPanel();
		entView.setLayout(entGrid);
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
		}
		
		//when you add a UnitButton, add an actionlistener to it. Since that actlis requires a reference to MainMap, 
		//it cannot be created outside the UI hierarchy because no one likes hideously intercoupled structures
		//Port this behavior to UnitQueue eventually.
		
		view = new JWindow();
		view.setLayout(new GridLayout(1, 2));
		view.add(terrView);
		view.add(entView);
		terrView.setBounds(xLoc, yLoc, terrW, height);
		entView.setBounds(entX, entY, entW, height);
		view.setBounds(xLoc, yLoc, width, height);
		
		terrView.setVisible(true);
		entView.setVisible(true);
		view.setVisible(true);
		
	}
	
	public TerrainType[] highestTerrains(int desired, int[] terrainCounts) {
		int[] terrainIDs = new int[desired];
		int[] tracker = new int[desired];
		for (int i = 0; i < desired; i++) {
			tracker[i] = -1;
			terrainIDs[i] = -1;
		}
		boolean placed;
		int supplicant;
		for (int j = 0; j < terrainCounts.length; j++) {
			placed = false;
			supplicant = terrainCounts[j];
			for (int k = 0; k < desired; k++) {
				if (! placed && supplicant > tracker[k]) {
					tracker[k] = supplicant;
					terrainIDs[k] = j;
					placed = true;
				}
			}
		}
		TerrainType[] result = new TerrainType[desired];
		for (int m = 0; m < desired; m++) {
			result[m] = TerrainType.getTerrainType(terrainIDs[m]);
		}
		return result;
	}
}
