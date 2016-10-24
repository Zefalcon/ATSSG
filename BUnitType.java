package ATSSG;
import java.util.Map;

public enum BUnitType {
	
	TYPES;
	
	public Map<BuildingType, Integer> constructionTimes;
	public Map<BuildingType, Map<RCommodityType, Integer>> constructionCosts;

}
