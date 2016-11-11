package ATSSG;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.nio.file.Paths;
import java.util.Map;

public enum UnitType {
	
	Void("Void", "", new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel").toString()), 0, null, 0, null, 0, 0),
	Soldier("Solder", "Soldier.", new ImageIcon(Paths.get("src/ATSSG/Art/DemoUnit.png").toString()), 5,
			null, 1, AttackType.STABBING, 1, 500);//flag instakill shortcut code.
	
	public String name;
	public String description;
	public Icon image;
	public int maxHP;
	public Map<TerrainType, Double> passableTerrain; 
	public int maxMoves;
	public AttackType aType;
	public int aRange;
	public int aDamage;
	
	private UnitType(String n, String d, Icon i, int mHP, Map<TerrainType, Double> pT, int mM, AttackType aT, int aR, int aD){
		name = n;
		description = d;
		image = i;
		maxHP = mHP;
		passableTerrain = pT;
		maxMoves = mM;
		aType = aT;
		aRange = aR;
		aDamage = aD;
	}
	
	public Icon getImage() {
		return image;
	}

}
