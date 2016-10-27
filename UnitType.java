package ATSSG;
import javax.swing.Icon;
import java.util.Map;

public enum UnitType {
	
	Soldier("Solder", "Soldier.", null, 5, null, 3, AttackType.STABBING, 1, 1);
	
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

}
