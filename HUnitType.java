package ATSSG;
import java.util.Map;

public enum HUnitType {
	
	TYPES;
	
	public Map<ResourceType, Integer> harvestTimes;
	public Map<ResourceType, Map<RCommodityType, Integer>> harvestGains;
	public Map<RCommodityType, Integer> carryingCapacities;

}
