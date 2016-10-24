package ATSSG;
import java.util.Collection;

public class CommandCard extends UIContainer<Button> {
	
	//Variables
	protected Collection<Button> commands;

	//Constructors
	public CommandCard(Collection<Button> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(content, card, xLoc, yLoc, width, height, displayLevel);
	}
}
