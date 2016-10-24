package ATSSG;

import java.util.Collection;

public class Minimap extends UIContainer<Cell> implements UIMap{
	
	public Minimap(Collection<Cell> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(content, card, xLoc, yLoc, width, height, displayLevel);
	}
	
	public void clicked(Cell ofInterest, ClickType ct){
		
	}

}
