package ATSSG.Script.Framework;

public class ControlStatement extends Statement {
	
	//Variables
	protected Statement trueBranch;
	protected Statement falseBranch;
	protected String condition;
	protected Boolean evaluation = null;
	
	public ControlStatement(Statement trueBranch, Statement falseBranch, String condition) {
		setTrueBranch(trueBranch);
		setFalseBranch(falseBranch);
		this.condition = condition;
	}

	@Override
	public boolean execute(Script environment) throws ScriptError {
		if (evaluation == Boolean.TRUE) {
			return trueBranch.execute(environment);
		} else if (evaluation == Boolean.FALSE) {
			return falseBranch.execute(environment);
		} else if (Expression.getBooleanValue(condition, environment)) {
			evaluation = Boolean.TRUE;
			return trueBranch.execute(environment);
		} else {
			evaluation = Boolean.FALSE;
			return falseBranch.execute(environment);
		}
	}
	
	@Override
	public boolean statementDone() {
		if (evaluation == Boolean.TRUE) {
			return trueBranch.statementDone();
		} else if (evaluation == Boolean.FALSE) {
			return falseBranch.statementDone();
		} else {
			return false;
		}		
	}
	
	public Statement getTrueBranch() {
		return trueBranch;
	}

	public void setTrueBranch(Statement trueBranch) {
		if (trueBranch == null) {
			trueBranch = new Block();
		}
		this.trueBranch = trueBranch;
	}

	public Statement getFalseBranch() {
		return falseBranch;
	}

	public void setFalseBranch(Statement falseBranch) {
		if (falseBranch == null) {
			falseBranch = new Block();
		}
		this.falseBranch = falseBranch;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Boolean getEvaluation() {
		return evaluation;
	}

	@Override
	public Statement copy() {
		return new ControlStatement(trueBranch.copy(), falseBranch.copy(), condition+"");
	}
}
