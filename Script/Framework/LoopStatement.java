package ATSSG.Script.Framework;

public class LoopStatement extends Statement {

	protected Statement originalbody;
	protected Statement progressbody;
	protected String condition;

	public LoopStatement(Statement body, String condition) {
		this.originalbody = body;
		this.progressbody = null;
		this.condition = condition;
	}
	
	@Override
	public boolean execute(Script environment) throws ScriptError {
		if (progressbody != null) {
			boolean result = progressbody.execute(environment);
			if (!result) {
				progressbody = null;
				return execute(environment);
			}
			return true;
		} else if (Expression.getBooleanValue(condition, environment)) {
			progressbody = originalbody.copy();
			return execute(environment);
		} else {
			originalbody = null;
			return false;
		}
	}

	@Override
	public boolean statementDone() {
		return originalbody == null;
	}
	
	public Statement getOriginalbody() {
		return originalbody;
	}

	public void setOriginalbody(Statement originalbody) {
		this.originalbody = originalbody;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Statement getProgressbody() {
		return progressbody;
	}

	@Override
	public Statement copy() {
		return new LoopStatement(originalbody.copy(), condition+"");
	}

}
