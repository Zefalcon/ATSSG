package ATSSG.Script.Framework;

import java.util.ArrayList;
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
	
	public Block(String wad, int d){
		this.lines = new ArrayList<Statement>();
		if(wad.length() > 0){
			//If we aren't given an empty block.
			String tag = "[" + d + "]";
			String w_cut = wad;
			int tag_loc = wad.indexOf(tag);
			while(tag_loc != -1){
				String line = w_cut.substring(0, tag_loc);
				lines.add(Statement.make(line));
				w_cut = w_cut.substring(tag_loc + wad.length());
				tag_loc = wad.indexOf(tag);
			}
		}
	}
	
	public void addStatement(Statement toAdd, int pos) {
		lines.add(pos, toAdd);
	}
	
	public void addAfter(Statement toAdd, Statement previousStatement) {
		if (previousStatement == null || !lines.contains(previousStatement)) {
			addStatement(toAdd, 0);
		} else {
			addStatement(toAdd, lines.indexOf(previousStatement)+1);
		}
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

	@Override
	public Statement copy() {
		Block b = new Block();
		for (Statement s: lines) {
			b.addAtEnd(s.copy());
		}
		return b;
	}
	
	@Override
	public String saveString(int depth){
		String wrapper = "(" + Integer.toString(depth) + ")";
		
		String total = wrapper;
		String line_wrapper = "[" + depth + "]";
		for(Statement s : lines){
			total = total + s.saveString(depth) + line_wrapper;
		}
		return total + wrapper;
	}
}