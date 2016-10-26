package ATSSG;
import javax.swing.Icon;
import java.util.Map;

public enum UnitType {
	
	TYPES;
	
	public String name;
	public String description;
	public Icon image;
	public int maxHP;
	public Map<TerrainType, Double> passableTerrain; 
	public int maxMoves;
	public AttackType aType;
	public int aRange;
	public int aDamage;

}
