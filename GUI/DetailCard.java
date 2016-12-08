package ATSSG.GUI;

import java.util.Collection;

import javax.swing.JPanel;

import ATSSG.Cell;
import ATSSG.Entities.Entity;
import ATSSG.Enums.TerrainType;
import ATSSG.Script.ScriptInterface;

public class DetailCard extends UIContainer<Entity> {
	
	//Variables
	protected MainMap mainMap;
	protected TerrainType terrain;
	protected TerrainCard terrCard;
	protected EntityCard entCard;
	
	//Constructors
	public DetailCard(Collection<Entity> occupiers, final int width, final int height, 
			MainMap mainMap, ScriptInterface si) {
		super(occupiers, width, height);
		
		entCard = new EntityCard(occupiers, width - height - 50, height, mainMap, si); //Flag that -50 is completely arbitrary and I'm not totally sure why I needed it
		
		terrCard = new TerrainCard(null, height, height);
		
		view = new JPanel();
		view.setPreferredSize(getSize());
		view.add(terrCard.getView());
		view.add(entCard.getView());
		view.setVisible(true);
	}
	
	//Methods
	
	//This update is called by turn ending functionality, just in case the units you selected die horribly.
	public void update() {
		entCard.update();
	}
	
	public void update(Cell cell) {
		terrCard.update(cell);
		content = cell.getOccupyingEntities();
		entCard.update(cell);
		
	}
}
