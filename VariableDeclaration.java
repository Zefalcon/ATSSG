package ATSSG;
import java.util.Collection;

public class VariableDeclaration<T> {
	
	//Variables
	protected String name;
	protected Collection<Variable<?>> scope;
	protected VariableProducer<T> value;

}
