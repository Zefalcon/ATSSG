package ATSSG.GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ATSSG.Cell;
import ATSSG.GameMap;
import ATSSG.Entities.Entity;
import ATSSG.Player.Player;

public class Minimap extends UIContainer<Cell> {
	
	//Fields
	GameMap gm;
	ImageIcon blank;
	JLabel map;
	BufferedImage storedTerrainMM = null;
	double xRes = -1;
	double yRes = -1;
	
	//Constructors
	
	public Minimap(Collection<Cell> content, int width, int height, GameMap gm) {
		super(content, width, height);
		this.gm = gm;
		view = new JPanel();
		ImageIcon blank = new ImageIcon(Paths.get("src/ATSSG/Art/BigBlankLabel.png").toString());
		map = new JLabel(blank);
		view.add(map);
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	//Methods
	
	public void updateAll() {
		Cell[][] state = gm.getCells();
		if (state == null) {
			map.setIcon(blank);
			return;
		}
		int stateW = state.length;
		int stateH = state[0].length;
		xRes = 300.0 / stateW;
		yRes = 300.0 / stateH;
		BufferedImage terrainMM;
		try {
			terrainMM = ImageIO.read(new File(Paths.get("src/ATSSG/Art/BlankMinimap.png").toString()));
			int k, l;
			for (int i = 0; i < 300; i ++) {
				for (int j = 0; j < 300; j ++) {
					k = (int) (i / xRes);
					l = (int) (j / yRes);
					terrainMM.setRGB(i, j, state[k][l].getTerrainType().getVisID().getRGB());	
				}
			}
			updateUnitPositions(terrainMM);
		} catch (IOException ioe) {System.out.println("Could not fetch minimap image");}
	}
	
	public void updateUnitPositions(BufferedImage newMinimap) {
		try {
			File file = new File(Paths.get("src/ATSSG/Art/PartialMinimapStorage.png").toString());
			ImageIO.write(newMinimap, "png", file);
			this.storedTerrainMM = ImageIO.read(file);
			Collection<Player> players = gm.getPlayers();
			for (Player p : players) {
				for (Entity e : p.getEntities()) {
					Cell cell = e.getContainingCell();
					for (int k = 0; k < xRes; k++) {
						for (int l = 0; l < yRes; l++) {
							newMinimap.setRGB((int)(xRes * cell.getX()) + k, (int)(yRes * cell.getY()) + l, p.getVisID().getRGB());
						}
					}
				}
			}
			map.setIcon(new ImageIcon(newMinimap.getScaledInstance((int) this.getSize().getWidth(), (int) this.getSize().getHeight(), Image.SCALE_SMOOTH)));
			view.revalidate();
			view.repaint();
		}
		catch (IOException e) {
			System.out.println("Could not write/read partial minimap file");
		}
		
	}
	
	public void endTurnUpdate() {
		updateUnitPositions(storedTerrainMM);
	}
}
