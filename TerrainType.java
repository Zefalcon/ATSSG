package ATSSG;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum TerrainType {
	
	VOID	("Void", "", Arrays.asList((Icon) new ImageIcon(Paths.get("src/ATSSG/Art/DemoVoid.png").toString()))),
	GRASS	("Grass", "An open, grassy area.", Arrays.asList((Icon) new ImageIcon(Paths.get("src/ATSSG/Art/DemoTerrain.png").toString()))),
	ROUGH_TERRAIN ("Rough Terrain", "A rocky, hilly area that is hard to traverse", 
			Arrays.asList((Icon) (new ImageIcon(Paths.get("src/ATSSG/Art/DemoRocks.png").toString())))),
	MOUNTAIN ("Mountain", "An area impassable to units", Arrays.asList((Icon) new ImageIcon(Paths.get("src/ATSSG/Art/DemoMountain.png").toString())));
	
	
	public String name;
	public String description;
	public List<Icon> images;
	
	TerrainType(String NAME, String DESCRIPTION, List<Icon> IMAGES){
		name = NAME;
		description = DESCRIPTION;
		images = IMAGES;
	}

	public String getName() {return name;}
	public Icon getImage() {
		return images.get(new Random().nextInt(images.size()));
	}
	public String getDescription() {return description;}
}