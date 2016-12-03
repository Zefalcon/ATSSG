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
	
	//Soldier("Solder", "Soldier.", Paths.get("src/ATSSG/Art/DemoUnit.png").toString(), 5,
	//		new InlineMap<TerrainType,Double>().returnPut(TerrainType.GRASS, 1.0), 1, AttackType.STABBING, 1, 500);//flag instakill shortcut code.
	Soldier(
		"Soldier",
		"A standard melee unit.",
		Paths.get("src/ATSSG/Art/DemoUnit.png").toString(),
		10,
		new InlineMap<TerrainType,Integer>()
			.returnPut(TerrainType.GRASS, 1)
			.returnPut(TerrainType.ROUGH_TERRAIN, 2),
		3,
		AttackType.STABBING,
		1,
		4
	),
	Archer(
		"Archer",
		"A basic ranged unit.",
		null,
		10,
		new InlineMap<TerrainType,Integer>()
			.returnPut(TerrainType.GRASS, 1)
			.returnPut(TerrainType.ROUGH_TERRAIN,  2),
		3,
		AttackType.STABBING,
		3,
		2
	),
	Guardtower(
		"Guardtower",
		"A stationary, ranged defensive structure.",
		null,
		15,
		new InlineMap<TerrainType,Integer>(),
		0,
		AttackType.STABBING,
		5,
		2
	),
	SeigeEngine(
		"Seige Engine",
		"A large, moving weapon.",
		null,
		5,
		new InlineMap<TerrainType,Integer>()
			.returnPut(TerrainType.GRASS, 1),
		1,
		AttackType.STABBING,
		8,
		20
	),
	Mountaineer(
		"Mountaineer",
		"A unit trained in navigating difficult terrain.",
		null,
		8,
		new InlineMap<TerrainType,Integer>()
			.returnPut(TerrainType.GRASS, 1)
			.returnPut(TerrainType.ROUGH_TERRAIN, 1)
			.returnPut(TerrainType.MOUNTAIN, 2),
		3,
		AttackType.STABBING,
		1,
		3
	),
	Cavalry(
		"Cavalier",
		"A fast, hard-hitting, fragile unit.",
		null,
		4,
		new InlineMap<TerrainType, Integer>().returnPut(TerrainType.GRASS, 1),
		8,
		AttackType.STABBING,
		1,
		6
	);
	//Archer("Archer", "A ranged unit.", null, 5, new InlineMap<TerrainType,Double>().returnPut(TerrainType.GRASS, 1.0), 1, AttackType.SHOOTING, 3, 1);

	HashMap<TerrainType,Double> warriorPassage = new HashMap<>();//flag what does this do?
	
	public String name;
	public String description;
	public String image_path;
	public int maxHP;
	public Map<TerrainType, Integer> passableTerrain; 
	public int maxMoves;
	public AttackType aType;
	public int aRange;
	public int aDamage;
	
	private UnitType(String n, String d, String path, int mHP, Map<TerrainType, Integer> pT, int mM, AttackType aT, int aR, int aD) {
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