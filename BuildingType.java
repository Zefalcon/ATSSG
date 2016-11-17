package ATSSG;

import java.awt.Image;
import java.util.Hashtable;
import java.util.Map;

public enum BuildingType {
	
	GENERIC("Building A", "A building", null, 100, new Hashtable<RCommodityType, Integer>(), new Hashtable<UnitType, Integer>(), new Hashtable<UnitType, Map<RCommodityType, Integer>>());
	
	public String name;
	public String description;
	public Image image;
	public int maxHP;
	public Map<RCommodityType, Integer> resourceYieldsAmts;
	public Map<UnitType, Integer> constructionTimes;
	public Map<UnitType, Map<RCommodityType,Integer>> constructionCosts;

	private BuildingType(String n, String desc, Image i, int HP, Map<RCommodityType, Integer> yield, Map<UnitType, Integer> times, Map<UnitType, Map<RCommodityType, Integer>> costs){
		name = n;
		description = desc;
		image = i;
		maxHP = HP;
		resourceYieldsAmts = yield;
		constructionTimes = times;
		constructionCosts = costs;
	}

	public Image getImage() {
		return image;
	}
}
