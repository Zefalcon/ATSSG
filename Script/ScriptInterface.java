package ATSSG.Script;
import java.util.Collection;

import ATSSG.Button;
import ATSSG.Overlay;
import ATSSG.Player.Player;

public class ScriptInterface extends Overlay {
	
	//Variables
	
	protected Collection<Button> scriptElements;
	protected Button execute;
	protected Collection<?> assemblyZone;

	//Constructors
	
	public ScriptInterface(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);
	}
}