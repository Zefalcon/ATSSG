package ATSSG;

import ATSSG.Enums.ResourceType;

public class ResourceItem {
	
	//Variables
	protected ResourceType type;
	protected int reserve;
	protected Cell containingCell;
	
	//Constructors
	
	//Methods
	public void kill(){
		
	}
	
	public int harvest(int wanted){
		//Is harvested by a harvester unit, returns amount harvested
		return 0;
	}

}
