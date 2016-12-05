package ATSSG;

import ATSSG.Enums.CommandType;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;
import ATSSG.GUI.Gooey;

public class Game {

	public static void main(String[] args) {
		int screenW = 1100;
		int screenH = 700;

		CommandType.setIconSizes((int)(screenH / 12.0), (int)(screenH / 12.0));
		TerrainType.setCardIconSizes(screenH / 4, (int) (3.0 * screenH / 16.0));
		UnitType.setCardImageSizes((int) (((screenW / 4.0) - (11.0 * screenH / 16.0))), (int) (screenH / 8.0));
		
		TerrainType.setCellIconSizes(-1, -1);
		
		GameMap map = new GameMap();
		new Gooey(screenW, screenH, 0, GameMap.getHuman(), map);
	}

}
