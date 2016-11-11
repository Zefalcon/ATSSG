package ATSSG;

import java.nio.file.Paths;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum TerrainType {
	
	VOID	("Void", "No Selection.", new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString())),
	GRASS	("Grass", "An open, grassy area.", new ImageIcon(Paths.get("src/ATSSG/Art/DemoTerrain.png").toString()));
	
	
	public String name;
	public String description;
	public Icon image;
	
	TerrainType(String NAME, String DESCRIPTION, Icon IMAGE){
		name = NAME;
		description = DESCRIPTION;
		image = IMAGE;
	}

	public String getName() {return name;}
	public Icon getImage() {return image;}
	public String getDescription() {return description;}
}