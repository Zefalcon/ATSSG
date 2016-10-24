package ATSSG;
import javax.swing.Icon;
import java.util.Map;

public enum BuildingType {
	
	TYPES;
	
	public String name;
	public String description;
	public Icon image;
	public int maxHP;
	public Map<RCommodityType, Integer> resourceYieldsAmts;
	public Map<UnitType, Integer> constructionTimes;
	public Map<UnitType, Map<RCommodityType,Integer>> constructionCosts;

}
