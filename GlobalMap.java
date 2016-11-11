package ATSSG;

import java.util.Collection;

import ATSSG.Player.Player;

public class GlobalMap extends Overlay {
	
	Collection<Cell> tiles;
	
	public GlobalMap(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);
	}
}
