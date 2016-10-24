package ATSSG;

import java.util.Collection;

public class Prompt extends Overlay {
	
	//Variables
	protected String message;
	protected Button goTo;

	//Methods
	public Prompt(Collection<Object> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(content, card, xLoc, yLoc, width, height, displayLevel);
	}
}
