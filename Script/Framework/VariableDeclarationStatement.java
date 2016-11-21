package ATSSG.Script.Framework;


public class VariableDeclarationStatement extends Statement {
	
	//Variables
	protected String name;
	protected Class<?> type;
	
	public VariableDeclarationStatement(String name, Class<?> varType) {
		this.name = name;
		this.type = varType;
	}
	
	@Override
	public boolean execute(Script environment) throws ScriptError {
		if (type == Double.TYPE) {
			environment.getHeap().put(name, 0.0);
		} else if (type == Boolean.TYPE) {
			environment.getHeap().put(name, false);
		} else {
			throw new ScriptError(environment, this, "Unknown variable type for variable \""+name+"\" : " + type.getCanonicalName());
		}
		return false;
	}
	
	@Override
	public boolean statementDone() {
		return true;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	@Override
	public Statement copy() {
		return new VariableDeclarationStatement(name, type);
	}


}
