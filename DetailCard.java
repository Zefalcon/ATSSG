package ATSSG;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import ATSSG.Entities.Entity;
import ATSSG.Player.Player;
import ATSSG.Script.ScriptInterface;

public class DetailCard extends UIContainer<Entity> {
	
	//Variables
	protected MainMap mainMap;
	protected TerrainType terrain;
	protected TerrainCard terrCard;
	protected EntityCard entCard;
	
	//Constructors
	public DetailCard(Collection<Entity> occupiers, TerrainType terrain, final int width, final int height, 
			final Player owner, MainMap mainMap, ScriptInterface si) {
		super(occupiers, width, height, owner);
		
		entCard = new EntityCard(occupiers, width - height - 50, height, owner, mainMap, si); //Flag that -50 is completely arbitrary and I'm not totally sure why I needed it
		
		ArrayList<TerrainType> altt = new ArrayList<TerrainType>(1);
		altt.add(TerrainType.VOID);
		terrCard = new TerrainCard(altt, height, height, owner);
		
		view = new JPanel();
		view.setPreferredSize(getSize());
		view.add(terrCard.getView());
		view.add(entCard.getView());
		view.setVisible(true);
	}
	
	//Methods
	
	//This update is called by turn ending functionality, just in case the units you selected die horribly. Or a nuke changes the terrain. Whichever.
	public void update() {
		update(content, terrain);
	}
	
	public void update(Collection<Entity> occupiers, TerrainType terrain) {
		terrCard.update(terrain);
		content = occupiers;
		entCard.update(content);
		
	}
}
