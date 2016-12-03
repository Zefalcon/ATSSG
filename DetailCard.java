package ATSSG;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Icon;
import javax.swing.JPanel;

import ATSSG.Entities.Entity;
import ATSSG.Script.ScriptInterface;

public class DetailCard extends UIContainer<Entity> {
	
	//Variables
	protected MainMap mainMap;
	protected TerrainType terrain;
	protected TerrainCard terrCard;
	protected EntityCard entCard;
	
	//Constructors
	public DetailCard(Collection<Entity> occupiers, TerrainType terrain, final int width, final int height, 
			MainMap mainMap, ScriptInterface si) {
		super(occupiers, width, height);
		
		entCard = new EntityCard(occupiers, width - height - 50, height, mainMap, si); //Flag that -50 is completely arbitrary and I'm not totally sure why I needed it
		
		ArrayList<TerrainType> altt = new ArrayList<TerrainType>(1);
		altt.add(TerrainType.VOID);
		terrCard = new TerrainCard(altt, height, height);
		
		view = new JPanel();
		view.setPreferredSize(getSize());
		view.add(terrCard.getView());
		view.add(entCard.getView());
		view.setVisible(true);
	}
	
	//Methods
	
	//This update is called by turn ending functionality, just in case the units you selected die horribly.
	public void update() {
		entCard.update(content);
	}
	
	public void update(Collection<Entity> occupiers, TerrainType terr, Icon icon) {
		terrCard.update(terr, icon);
		content = occupiers;
		entCard.update(content);
		
	}
}
