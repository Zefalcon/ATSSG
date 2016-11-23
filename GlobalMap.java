package ATSSG;

import java.util.Collection;

public class GlobalMap extends Overlay {
	
	Collection<Cell> tiles;
	
	public GlobalMap(Collection<Object> content, int width, int height) {
		super(content, width, height);
	}
}
