package ATSSG;
import java.util.Collection;
import ATSSG.Player.Player;

public class HarvesterUnit extends Unit {
	
	HUnitType hType;
	RCommodityType cargoType;
	int cargoAmount;
	int depositProgress;
	ResourceItem depositTarget;
	public HarvesterUnit(HUnitType h, Player player, Cell location){
		super(h.baseUnit, player, location);
	}
	
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
