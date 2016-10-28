package ATSSG;
import java.util.Collection;

public class Menu extends Overlay {
	
	//Variables
	protected Collection<Button> menuButtons;

	//Methods
	public Menu(Collection<Object> content, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner) {
		super(content, xLoc, yLoc, width, height, displayLevel, owner);
	}
}
