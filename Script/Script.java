package ATSSG.Script;
import java.util.Collection;

import ATSSG.Entities.Entity;

public class Script {
	
	//Variables
	protected Collection<Statement> lines;
	protected Collection<Variable<?>> heap;
	protected ControlStatement caller;
	protected Entity executor;
	
	//Constructors
	
	//Methods
	public boolean execute() throws ScriptError{
		return false;
	}

}
