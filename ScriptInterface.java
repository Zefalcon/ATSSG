package ATSSG;
import java.util.Collection;

import ATSSG.Player.Player;

public class ScriptInterface extends Overlay {
	
	//Variables
	protected Collection<Button> scriptElements;
	protected Button execute;
	protected Collection<?> assemblyZone;

	//Methods
	public ScriptInterface(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);
	}
}
