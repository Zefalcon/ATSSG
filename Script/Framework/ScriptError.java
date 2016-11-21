package ATSSG.Script.Framework;

@SuppressWarnings("serial")
public class ScriptError extends Throwable{
	
	//Variables
	protected Script subjectScript;
	protected Statement subjectStatement;
	protected String issue;
	
	public ScriptError(Script subjectScript, Statement subjectStatement, String issue) {
		super();
		this.subjectScript = subjectScript;
		this.subjectStatement = subjectStatement;
		this.issue = issue;
	}

}
