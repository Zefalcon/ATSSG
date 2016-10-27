package ATSSG.Script;
import java.util.Collection;

import ATSSG.Button;
import ATSSG.Layout;
import ATSSG.Overlay;

public class ScriptInterface extends Overlay {
	
	//Variables
	protected Collection<Button> scriptElements;
	protected Button execute;
	protected Collection<?> assemblyZone;

	//Methods
	public ScriptInterface(Collection<Object> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(content, card, xLoc, yLoc, width, height, displayLevel);
	}
}
