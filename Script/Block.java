package ATSSG.Script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Block extends Statement {
	protected List<Statement> lines;

	public List<Statement> getLines() {
		return lines;
	}

	//Constructors
	public Block() {
		lines = new ArrayList<Statement>();
	}
	
	public void addStatement(Statement toAdd, int pos) {
		lines.add(pos, toAdd);
	}
	
	public void addAfter(Statement toAdd, Statement previousStatement) {
		if (previousStatement == null || !lines.contains(previousStatement)) {
			addStatement(toAdd, 0);
		}
		addStatement(toAdd, lines.indexOf(previousStatement));
	}

	public void addAtEnd(Statement toAdd){
		lines.add(toAdd);
	}
	
	public void removeStatement(Statement toRemove) {
		lines.remove(toRemove);
	}
	
	public void removeStatement(int pos) {
		lines.remove(pos);
	}

	@Override
	public boolean execute(Script environment) throws ScriptError {
		while (!lines.isEmpty()) {
			if (lines.get(0).execute(environment)) {
				if (lines.get(0).statementDone()) {
					lines.remove(0);
				}
				return true;
			} else { //statements will completely execute if they do not encounter a stop
				lines.remove(0);
			}
		}
		return false;
	}

	@Override
	public boolean statementDone() {
		return lines.isEmpty();
	}
}