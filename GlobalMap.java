package ATSSG;

import java.util.Collection;

public class GlobalMap extends Overlay implements UIMap {
	
	Collection<Cell> tiles;
	
	public GlobalMap(Collection<Object> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(content, card, xLoc, yLoc, width, height, displayLevel);
	}
	
	public void clicked(Cell ofInterest, ClickType ct){
		
	}

}
