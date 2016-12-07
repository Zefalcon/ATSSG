package ATSSG.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import ATSSG.Entities.Entity;
import ATSSG.Enums.RCommodityType;
import ATSSG.GameMap;

public class HumanPlayer extends Player {

	protected int stX, stY;
	
	public HumanPlayer(Map<RCommodityType, Integer> startingResources, List<Entity> starting_entities, GameMap map) {
		resources = startingResources;
		owned_entities = starting_entities;
		containing_map = map;
		stX = 9;
		stY = 9; //Flag: arbitrary numbers
		try {colors = ImageIO.read(new File(Paths.get("src/ATSSG/Art/HumanColorsDefault.png").toString()));} catch (IOException e) {}
	}
	
	@Override
	public void executeAll() {
		if (owned_entities == null) return;
		for (Entity e: owned_entities) {
			try {
				e.executeAction();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void setGameMap(GameMap gm) {
		containing_map = gm;
	}
	
	public void setStartingX(int stX) {this.stX = stX;}
	public void setStartingY(int stY) {this.stY = stY;}
	public int getStartingX() {return stX;}
	public int getStartingY() {return stY;}
}
