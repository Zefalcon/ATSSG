package ATSSG;

public class Game {

	public static void main(String[] args) {
		GameMap map = new GameMap();
		new Gooey(700, 1100, 0, GameMap.getHuman(), map);
	}

}
