package ATSSG;
import java.util.Collection;

public class HarvesterUnit extends Unit {
	
	HUnitType hType;
	RCommodityType cargoType;
	int cargoAmount;
	int depositProgress;
	ResourceItem depositTarget;
	
	//Methods
	public boolean canHarvest(ResourceItem resource){
		return false;
	}
	
	public Collection<ResourceItem> validHarvestTargets(){
		return null;
	}
	
	public boolean canDeposit(Building drop){
		return false;
	}
	
	public Collection<Building> validDepositTargets(){
		return null;
	}
	
	public boolean deposit(Building drop){
		return false;
	}

	public boolean harvest(ResourceItem resource){
		return false;
	}

}
