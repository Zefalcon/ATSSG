package ATSSG;
import java.util.Collection;

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
