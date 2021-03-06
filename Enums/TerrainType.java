package ATSSG.Enums;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

public enum TerrainType {
	
	VOID	("Void", "", Color.BLACK, Arrays.asList(Paths.get("src/ATSSG/Art/DemoVoid.png").toString())),
	GRASS	("Grass", "An open, grassy area.", new Color(10, 100, 10), Arrays.asList(
			Paths.get("src/ATSSG/Art/DemoGrass.png").toString(),
			Paths.get("src/ATSSG/Art/DemoGrass2.png").toString(),
			Paths.get("src/ATSSG/Art/DemoGrass3.png").toString())),
	ROUGH_TERRAIN ("Rough Terrain", "A rocky, hilly area that is hard to traverse", new Color(180, 130, 90), Arrays.asList(
			Paths.get("src/ATSSG/Art/DemoRocks.png").toString(),
			Paths.get("src/ATSSG/Art/DemoRocks2.png").toString(),
			Paths.get("src/ATSSG/Art/DemoRocks3.png").toString())),
	MOUNTAIN ("Mountain", "An area impassable to units", Color.DARK_GRAY, Arrays.asList(
			Paths.get("src/ATSSG/Art/DemoMountain.png").toString(),
			Paths.get("src/ATSSG/Art/DemoMountain2.png").toString(),
			Paths.get("src/ATSSG/Art/DemoMountain3.png").toString()));
	
	
	public String name;
	public String description;
	public List<String> paths;
	public List<Image> cellImages;
	public List<Image> cardImages;
	public List<Image> images;
	public Color visID;
	public static int cardW, cardH;
	
	TerrainType(String NAME, String DESCRIPTION, Color visID, List<String> paths) {
		name = NAME;
		description = DESCRIPTION;
		this.paths = paths;
		this.visID = visID;
		cellImages = new ArrayList<Image>(4);
		cardImages = new ArrayList<Image>(4);
		images = new ArrayList<Image>(4);
		for (String s : paths) {
			try {
				Image i = ImageIO.read(new File(s));
				images.add(i);
				cellImages.add(i);
				cardImages.add(i);
			} catch (IOException ioe) {
				System.out.println("Image Files not found for terrains");
			}
		}
	}
	
	public static void setCellIconSizes(int ciW, int ciH) {
		VOID.cellImages.clear();
		for (Image i : VOID.images) {
			VOID.cellImages.add(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH));
		}
		GRASS.cellImages.clear();
		for (Image i : GRASS.images) {
			GRASS.cellImages.add(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH));
		}
		ROUGH_TERRAIN.cellImages.clear();
		for (Image i : ROUGH_TERRAIN.images) {
			ROUGH_TERRAIN.cellImages.add(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH));
		}
		MOUNTAIN.cellImages.clear();
		for (Image i : MOUNTAIN.images) {
			MOUNTAIN.cellImages.add(i.getScaledInstance(ciW, ciH, Image.SCALE_SMOOTH));
		}
	}
	
	public static void setCardIconSizes(int cardW, int cardH) {
		VOID.cardImages = new ArrayList<Image>(4);
		for (Image i : VOID.images) {
			VOID.cardImages.add(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH));
		}
		GRASS.cardImages = new ArrayList<Image>(4);
		for (Image i : GRASS.images) {
			GRASS.cardImages.add(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH));
		}
		ROUGH_TERRAIN.cardImages = new ArrayList<Image>(4);
		for (Image i : ROUGH_TERRAIN.images) {
			ROUGH_TERRAIN.cardImages.add(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH));
		}
		MOUNTAIN.cardImages = new ArrayList<Image>(4);
		for (Image i : MOUNTAIN.images) {
			MOUNTAIN.cardImages.add(i.getScaledInstance(cardW, cardH, Image.SCALE_SMOOTH));
		}
	}
	
	public String getName() {return name;}
	public int getTerrainFlavor() {
		return (int) (Math.random() * images.size());
	}
	public Image[] getImages(int flavor) {
		Image[] ret = new Image[3];
		ret[0] = cellImages.get(flavor);
		ret[1] = cardImages.get(flavor);
		try {ret[2] = ImageIO.read(new File(paths.get(flavor)));} catch (IOException ioe) {ret[2] = null;}
		return ret;
	}
	public String getDescription() {return description;}
	public Color getVisID() {return visID;}
}