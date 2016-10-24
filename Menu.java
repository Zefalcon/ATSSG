package ATSSG;
import java.util.Collection;

public class Menu extends Overlay {
	
	//Variables
	protected Collection<Button> menuButtons;

	//Methods
	public Menu(Collection<Object> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(content, card, xLoc, yLoc, width, height, displayLevel);
	}
}
