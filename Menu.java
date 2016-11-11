package ATSSG;
import java.util.Collection;

import ATSSG.Player.Player;

public class Menu extends Overlay {
	
	//Variables
	protected Collection<Button> menuButtons;

	//Methods
	public Menu(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);
	}
}
