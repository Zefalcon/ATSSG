package ATSSG.Script;

public abstract class Statement {
		
	//Methods
	/**
	 * @return true if the execute set the unit's actions
	 * @throws ScriptError
	 */
	public abstract boolean execute(Script environment) throws ScriptError;
	
	/**
	 * 
	 * @return true if the statement does not need another turn
	 */
	public abstract boolean statementDone();

}
