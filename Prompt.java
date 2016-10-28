package ATSSG;

import java.util.Collection;

public class Prompt extends Overlay {
	
	//Variables
	protected String message;
	protected Button goTo;

	//Methods
	public Prompt(Collection<Object> content, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner) {
		super(content,  xLoc, yLoc, width, height, displayLevel, owner);
	}
}
