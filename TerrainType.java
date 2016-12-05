package ATSSG;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
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
	public List<ImageIcon> cellIcons;
	public List<ImageIcon> cardIcons;
	public List<Image> images;
	public static int cardW, cardH;
	
	TerrainType(String NAME, String DESCRIPTION, List<String> paths) {
		name = NAME;
		description = DESCRIPTION;
		this.paths = paths;
		cellIcons = new ArrayList<ImageIcon>(4);
		cardIcons = new ArrayList<ImageIcon>(4);
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
	
	public static void setCellIconSizes(int ciW, int ciH) {
		VOID.cellIcons.clear();
		for (Image i : VOID.images) {
			VOID.cellIcons.add(new ImageIcon(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH)));
		}
		GRASS.cellIcons.clear();
		for (Image i : GRASS.images) {
			GRASS.cellIcons.add(new ImageIcon(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH)));
		}
		ROUGH_TERRAIN.cellIcons.clear();
		for (Image i : ROUGH_TERRAIN.images) {
			ROUGH_TERRAIN.cellIcons.add(new ImageIcon(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH)));
		}
		MOUNTAIN.cellIcons.clear();
		for (Image i : MOUNTAIN.images) {
			MOUNTAIN.cellIcons.add(new ImageIcon(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH)));
		}
	}
	
	public static void setCardIconSizes(int cardW, int cardH) {
		VOID.cardIcons.clear();
		for (Image i : VOID.images) {
			VOID.cardIcons.add(new ImageIcon(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH)));
		}
		GRASS.cardIcons.clear();
		for (Image i : GRASS.images) {
			GRASS.cardIcons.add(new ImageIcon(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH)));
		}
		ROUGH_TERRAIN.cardIcons.clear();
		for (Image i : ROUGH_TERRAIN.images) {
			ROUGH_TERRAIN.cardIcons.add(new ImageIcon(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH)));
		}
		MOUNTAIN.cardIcons.clear();
		for (Image i : MOUNTAIN.images) {
			MOUNTAIN.cardIcons.add(new ImageIcon(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH)));
		}
	}
	
	public String getName() {return name;}
	public Icon[] getIcons() {
		int rand = (int) (Math.random() * images.size());
		Icon[] ret = new Icon[2];
		ret[0] = cellIcons.get(rand);
		ret[1] = cardIcons.get(rand);
		return ret;
	}
	public String getDescription() {return description;}
}