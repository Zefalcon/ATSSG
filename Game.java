package ATSSG;

import java.io.IOException;

public class Game {

	public static void main(String[] args) {
		int screenW = 1100;
		int screenH = 700;
		try {
			CommandType.populateImages();
			TerrainType.populateImages();
			UnitType.populateImages();
		} catch (IOException e) {
			System.out.println("Image files not found.");
		}
		
		CommandType.setIconSizes((int)(screenH / 12.0), (int)(screenH / 12.0));
		TerrainType.setCardIconSizes(screenH / 4, (int) (3.0 * screenH / 16.0));
		UnitType.setCardImageSizes((int) (((screenW / 4.0) - (11.0 * screenH / 16.0))), (int) (screenH / 8.0));
		
		GameMap map = new GameMap();
		new Gooey(screenW, screenH, 0, GameMap.getHuman(), map);
	}

}
