package ATSSG;
import java.util.Collection;
import javax.swing.Icon;

public class ResourceCard extends UIContainer<Integer>{
	
	//Variables
	protected Collection<ResourceType> resources;
	protected Collection<Icon> pics;
	
	//Constructors
	public ResourceCard(Collection<Integer> quantities, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel, Collection<Icon> pics) {
		super(quantities, card, xLoc, yLoc, width, height, displayLevel);
		this.pics = pics;
	}
	
	//Methods
	public void update(int resource, int transaction){
		
	}

}
