package ATSSG.Script.Framework;

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
	
	public abstract Statement copy();
	
	public abstract String saveString(int depth);
	
	public static Statement make(String line, int d){
		System.out.println("Making from " + line);
		if(line.charAt(0) == '('){
			System.out.println("Making a new block.");//TODO
			return null;
		}
		else{
			String tag = line.substring(0, line.indexOf(':'));
			System.out.println("Collected tag " + tag);//TODO
			return null;
		}
	}
}