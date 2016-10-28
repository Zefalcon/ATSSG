package ATSSG;

import java.util.Collection;

import ATSSG.Player.Player;

public class GlobalMap extends Overlay {
	
	Collection<Cell> tiles;
	
	public GlobalMap(Collection<Object> content, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner) {
		super(content, xLoc, yLoc, width, height, displayLevel, owner);
	}
}
