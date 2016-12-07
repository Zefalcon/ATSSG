package ATSSG.Enums;

import java.util.HashMap;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import javax.imageio.ImageIO;

import ATSSG.InlineMap;

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
		Paths.get("src/ATSSG/Art/DemoArcher.png").toString(),
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
		Paths.get("src/ATSSG/Art/DemoTower.png").toString(),
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
		Paths.get("src/ATSSG/Art/DemoSeige.png").toString(),
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
		Paths.get("src/ATSSG/Art/DemoHiker.png").toString(),
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
		Paths.get("src/ATSSG/Art/DemoCavalry.png").toString(),
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
	public String path;
	public int maxHP;
	public Map<TerrainType, Integer> passableTerrain; 
	public int maxMoves;
	public AttackType aType;
	public int aRange;
	public int aDamage;
	public Image image;
	public static int smallW = 0;
	public static int smallH = 0;
	public static int cardW;
	public static int cardH;
	
	private UnitType(String n, String d, String path, int mHP, Map<TerrainType, Integer> pT, int mM, AttackType aT, int aR, int aD) {
		name = n;
		description = d;
		this.path = path;
		maxHP = mHP;
		passableTerrain = pT;
		maxMoves = mM;
		aType = aT;
		aRange = aR;
		aDamage = aD;
	}
	
	public static void setCardImageSizes(int cardW, int cardH) {
		UnitType.cardW = cardW;
		UnitType.cardH = cardH;
	}
	
	public static Image resizeCard(Image i) {
		if (cardW > 0 && cardH > 0) return i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH);
		else return i;
	}
	
	public Image getImage() {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Error fetching an image file");
			return null;
		}
	}

}