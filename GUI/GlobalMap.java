package ATSSG.GUI;

import java.util.Collection;

import ATSSG.Cell;

public class GlobalMap extends Overlay {
	
	Collection<Cell> tiles;
	
	public GlobalMap(Collection<Object> content, int width, int height) {
		super(content, width, height);
	}
}
