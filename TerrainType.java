package ATSSG;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public enum TerrainType {
	
	VOID	("Void", "", Arrays.asList(Paths.get("src/ATSSG/Art/DemoVoid.png").toString())),
	GRASS	("Grass", "An open, grassy area.", Arrays.asList(Paths.get("src/ATSSG/Art/DemoTerrain.png").toString())),
	ROUGH_TERRAIN ("Rough Terrain", "A rocky, hilly area that is hard to traverse", 
			Arrays.asList(Paths.get("src/ATSSG/Art/DemoRocks.png").toString())),
	MOUNTAIN ("Mountain", "An area impassable to units", Arrays.asList(Paths.get("src/ATSSG/Art/DemoMountain.png").toString()));
	
	
	public String name;
	public String description;
	public List<String> paths;
	public List<ImageIcon> icons;
	public List<ImageIcon> bigIcons;
	public List<Image> images;
	public static int cardW, cardH;
	
	TerrainType(String NAME, String DESCRIPTION, List<String> paths) {
		name = NAME;
		description = DESCRIPTION;
		this.paths = paths;
		icons = new ArrayList<ImageIcon>(4);
		bigIcons = new ArrayList<ImageIcon>(4);
		images = new ArrayList<Image>(4);
	}
	
	public static void populateImages() throws IOException {
		for (String s : VOID.paths) {
			VOID.images.add(ImageIO.read(new File(s)));
		}
		for (String s : GRASS.paths) {
			GRASS.images.add(ImageIO.read(new File(s)));
		}
		for (String s : ROUGH_TERRAIN.paths) {
			ROUGH_TERRAIN.images.add(ImageIO.read(new File(s)));
		}
		for (String s : MOUNTAIN.paths) {
			MOUNTAIN.images.add(ImageIO.read(new File(s)));
		}
	}
	
	public static void setCardIconSizes(int cardW, int cardH) {
		TerrainType.cardW = cardW;
		TerrainType.cardH = cardH;
	}
	
	public String getName() {return name;}
	public Image[] getImage() {
		int rand = (int) (Math.random() * images.size());
		Image[] ret = new Image[2];
		ret[0] = images.get(rand);
		ret[1] = images.get(rand).getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH);
		return ret;
	}
	public String getDescription() {return description;}
}