package ATSSG;
import javax.swing.Icon;

public enum TerrainType {
	
	GRASS	("Grass",	"An open, grassy area.", 	null);//Put the finished grass icon here.
	
	public String name;
	public String description;
	public Icon image;
	
	TerrainType(String NAME, String DESCRIPTION, Icon IMAGE){
		name = NAME;
		description = DESCRIPTION;
		image = IMAGE;
	}

}