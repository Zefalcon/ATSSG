package ATSSG.Script.Framework;

import java.util.regex.Pattern;

public class VariableDeclarationStatement extends Statement {
	
	//Variables
	protected String name;
	protected Class<?> type;
	
	public VariableDeclarationStatement(String name, Class<?> varType) throws ScriptError {
		if (!Pattern.matches("^[a-zA-Z][a-zA-Z_$0-9]*$", name)) {
			throw new ScriptError(null, this, "Invalid variable name: " + name);
		}		
		this.name = name;
		this.type = varType;
	}
	
	@Override
	public boolean execute(Script environment) throws ScriptError {
		if (type == Double.class) {
			environment.getHeap().put(name, 0.0);
		} else if (type == Boolean.class) {
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
		try {
			return new VariableDeclarationStatement(name+"", type);
		} catch (ScriptError e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String saveString(int d){
		return "dec:" + name + "," + type.getName();
	}
}