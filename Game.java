package ATSSG;

public class Game {

	public static void main(String[] args) {
		GameMap map = new GameMap();
		new Gooey(600, 1000, 0, GameMap.getHuman(), map);
	}

}
