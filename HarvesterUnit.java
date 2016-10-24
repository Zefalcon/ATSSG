package ATSSG;
import java.util.Collection;

public interface HarvesterUnit {
	
	//Same issue with variables as BuilderUnit
	//HUnitType hType
	//RCommodityType cargoType
	//int cargoAmount
	//int depositProgress
	//ResourceItem depositTarget
	
	//Methods
	public boolean canHarvest(ResourceItem resource);
	
	public Collection<ResourceItem> validHarvestTargets();
	
	public boolean canDeposit(Building drop);
	
	public Collection<Building> validDepositTargets();
	
	public void deposit(Building drop);

}
