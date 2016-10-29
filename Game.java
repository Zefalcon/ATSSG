package ATSSG;

import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;

public class Game {

	public static void main(String[] args) {
		GameMap map = new GameMap();
		Player human = null;
		for (Player p: map.getPlayers()) {
			if (p instanceof HumanPlayer) {
				human = p;
				break;
			}
		}
		Gooey g = new Gooey(600, 800, 0, human, map);

	}

}
