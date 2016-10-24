package ATSSG;
import java.util.Collection;

public class Variable<T> {
	
	//Variables
	protected String name;
	protected Collection<Variable<?>> scope;
	protected T value;
}
