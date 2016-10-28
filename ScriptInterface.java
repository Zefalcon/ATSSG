package ATSSG;
import java.util.Collection;

import ATSSG.Player.Player;

public class ScriptInterface extends Overlay {
	
	//Variables
	protected Collection<Button> scriptElements;
	protected Button execute;
	protected Collection<?> assemblyZone;

	//Methods
	public ScriptInterface(Collection<Object> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner) {
		super(content, xLoc, yLoc, width, height, displayLevel, owner);
	}
}
