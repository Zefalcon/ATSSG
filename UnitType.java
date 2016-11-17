package ATSSG;

import java.util.HashMap;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import javax.imageio.ImageIO;

public enum UnitType {
	
	Void("Void", "", Paths.get("src/ATSSG/Art/BlankLabel.png").toString(), 0, null, 0, null, 0, 0),
	Soldier("Solder", "Soldier.", Paths.get("src/ATSSG/Art/DemoUnit.png").toString(), 5,
			new InlineMap<TerrainType,Double>().returnPut(TerrainType.GRASS, 1.0), 1, AttackType.STABBING, 1, 500);//flag instakill shortcut code.
	//RealSoldier("Soldier", "A stronger melee unit.", null, 5, new InlineMap<TerrainType,Double>().returnPut(TerrainType.GRASS, 1.0), 1, AttackType.STABBING, 1, 3),
	//Archer("Archer", "A ranged unit.", null, 5, new InlineMap<TerrainType,Double>().returnPut(TerrainType.GRASS, 1.0), 1, AttackType.SHOOTING, 3, 1);

	HashMap<TerrainType,Double> warriorPassage = new HashMap<>();
	
	public String name;
	public String description;
	public String image_path;
	public int maxHP;
	public Map<TerrainType, Double> passableTerrain; 
	public int maxMoves;
	public AttackType aType;
	public int aRange;
	public int aDamage;
	
	private UnitType(String n, String d, String path, int mHP, Map<TerrainType, Double> pT, int mM, AttackType aT, int aR, int aD) {
		name = n;
		description = d;
		image_path = path;
		maxHP = mHP;
		passableTerrain = pT;
		maxMoves = mM;
		aType = aT;
		aRange = aR;
		aDamage = aD;
	}
	
	public Image getImage() {
		Image image = null;
		try {image = ImageIO.read(new File(image_path));} catch (IOException e) {}
		return image;
	}

}