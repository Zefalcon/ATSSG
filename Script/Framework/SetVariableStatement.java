package ATSSG.Script.Framework;


public class SetVariableStatement extends Statement {
	
	String name;
	String value;

	public SetVariableStatement(String varname, String expression) {
		name = varname;
		value = expression;
	}

	@Override
	public boolean statementDone() {
		return true;
	}

	@Override
	public boolean execute(Script environment) throws ScriptError {
		Object previous = environment.getHeap().get(name);
		if (previous == null) {
			throw new ScriptError(environment, this, "Using undeclared variable");
		}
		if (previous instanceof Boolean) {
			environment.getHeap().put(name, Expression.getBooleanValue(value, environment));
		} else if (previous instanceof Double) {
			environment.getHeap().put(name, Expression.getDoubleValue(value, environment));
		} else {
			throw new ScriptError(environment, this, "Unknown variable type for variable \""+name+"\" : " + previous.getClass());
		}
		return false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Statement copy() {
		return new SetVariableStatement(name, value);
	}
	
}