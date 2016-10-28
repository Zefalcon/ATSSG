package ATSSG;
import java.util.Collection;
import javax.swing.Icon;

public class ResourceCard extends UIContainer<Integer>{
	
	//Variables
	protected Collection<ResourceType> resources;
	protected Collection<Icon> pics;
	
	//Constructors
	public ResourceCard(Collection<Integer> quantities, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner, Collection<Icon> pics) {
		super(quantities, xLoc, yLoc, width, height, displayLevel, owner);
		this.pics = pics;
	}
	
	//Methods
	public void update(int resource, int transaction){
		
	}

}
