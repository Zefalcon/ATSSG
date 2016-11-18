package ATSSG.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import ATSSG.Entities.Entity;
import ATSSG.GameMap;
import ATSSG.RCommodityType;

public class HumanPlayer extends Player {

	public HumanPlayer(Map<RCommodityType, Integer> startingResources, List<Entity> starting_entities, GameMap map) {
		resources = startingResources;
		owned_entities = starting_entities;
		containing_map = map;
		try {colors = ImageIO.read(new File(Paths.get("src/ATSSG/Art/HumanColorsDefault.png").toString()));} catch (IOException e) {}
	}
	
	@Override
	public void executeAll() {
		if (owned_entities == null) return;
		// TODO Execute the script
		for (Entity e: owned_entities) {
			e.executeAction();
		}
	}

	public void setGameMap(GameMap gm) {
		containing_map = gm;
	}
}