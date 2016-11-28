package ATSSG;

import java.nio.file.Paths;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum TerrainType {
	
	VOID	("Void", "", new ImageIcon(Paths.get("src/ATSSG/Art/DemoVoid.png").toString())),
	GRASS	("Grass", "An open, grassy area.", new ImageIcon(Paths.get("src/ATSSG/Art/DemoTerrain.png").toString())),
	ROUGH_TERRAIN ("Rough Terrain", "A rocky, hilly area that is hard to traverse", new ImageIcon(Paths.get("src/ATSSG/Art/DemoRocks.png").toString())),
	MOUNTAIN ("Mountain", "An area impassable to units", new ImageIcon(Paths.get("src/ATSSG/Art/DemoMountain.png").toString()));
	
	
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