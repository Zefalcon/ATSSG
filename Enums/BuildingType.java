package ATSSG.Enums;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

public enum BuildingType {
	
	GENERIC("Building A", "A building", null, 100, new Hashtable<RCommodityType, Integer>(), new Hashtable<UnitType, Integer>(), new Hashtable<UnitType, Map<RCommodityType, Integer>>());
	
	public String name;
	public String description;
	public Image image;
	public String path;
	public int maxHP;
	public Map<RCommodityType, Integer> resourceYieldsAmts;
	public Map<UnitType, Integer> constructionTimes;
	public Map<UnitType, Map<RCommodityType,Integer>> constructionCosts;

	private BuildingType(String n, String desc, String p, int HP, Map<RCommodityType, Integer> yield, Map<UnitType, Integer> times, Map<UnitType, Map<RCommodityType, Integer>> costs){
		name = n;
		description = desc;
		path = p;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Error fetching a building image");
		}
		maxHP = HP;
		resourceYieldsAmts = yield;
		constructionTimes = times;
		constructionCosts = costs;
	}

	public Image getImage() {
		return image;
	}
	public String getPath() {
		return path;
	}
}
