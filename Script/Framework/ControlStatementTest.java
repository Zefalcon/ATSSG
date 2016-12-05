package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ATSSG.Cell;
import ATSSG.TerrainType;
import ATSSG.UnitType;
import ATSSG.Actions.IdleAction;
import ATSSG.Entities.Unit;

public class ControlStatementTest {

	@Test
	public void testExecute() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		Block b1 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var1", Double.class));
		b1.addAtEnd(new ActionStatement(new IdleAction()));
		b1.addAtEnd(new VariableDeclarationStatement("var2", Boolean.class));
		Block b2 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var3", Double.class));
		ControlStatement c1 = new ControlStatement(b1.copy(), b2.copy(), "true");
		assert(!s.getHeap().containsKey("var1"));
		assert(!s.getHeap().containsKey("var2"));
		assert(!s.getHeap().containsKey("var3"));
		c1.execute(s);
		assert(s.getHeap().containsKey("var1"));
		assert(!s.getHeap().containsKey("var2"));
		assert(!s.getHeap().containsKey("var3"));
		c1.execute(s);
		assert(s.getHeap().containsKey("var1"));
		assert(s.getHeap().containsKey("var2"));
		assert(!s.getHeap().containsKey("var3"));
		s = new Script(u);
		ControlStatement c2 = new ControlStatement(b1.copy(), b2.copy(), "false");
		assert(!s.getHeap().containsKey("var1"));
		assert(!s.getHeap().containsKey("var2"));
		assert(!s.getHeap().containsKey("var3"));
		c2.execute(s);
		assert(!s.getHeap().containsKey("var1"));
		assert(!s.getHeap().containsKey("var2"));
		assert(s.getHeap().containsKey("var3"));
	}

	@Test
	public void testStatementDone() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		Block b1 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var1", Double.class));
		b1.addAtEnd(new ActionStatement(new IdleAction()));
		b1.addAtEnd(new VariableDeclarationStatement("var2", Boolean.class));
		Block b2 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var3", Double.class));
		ControlStatement c1 = new ControlStatement(b1.copy(), b2.copy(), "true");
		assert(!c1.statementDone());
		c1.execute(s);
		assert(!c1.statementDone());
		c1.execute(s);
		assert(c1.statementDone());
		ControlStatement c2 = new ControlStatement(b1.copy(), b2.copy(), "false");
		assert(!c2.statementDone());
		c2.execute(s);
		assert(c2.statementDone());
		ControlStatement c3 = new ControlStatement(null, null, "false");
		assert(!c3.statementDone());
		c3.execute(s);
		assert(c3.statementDone());
		
		
	}

	@Test
	public void testCopy() throws ScriptError {
		Statement s1 = new VariableDeclarationStatement("var1", Double.class);
		Statement s2 = new VariableDeclarationStatement("var2", Boolean.class);
		ControlStatement orig = new ControlStatement(s1, s2, "true");
		ControlStatement copy = (ControlStatement) orig.copy();
		assert(orig != copy);
		assert(orig.getCondition() != copy.getCondition());
		assert(orig.getCondition().equals(copy.getCondition()));
		assert(orig.getTrueBranch() != copy.getTrueBranch());
		assert(((VariableDeclarationStatement) orig.getTrueBranch()).getName().equals(
				((VariableDeclarationStatement) copy.getTrueBranch()).getName()));
		assert(((VariableDeclarationStatement) orig.getTrueBranch()).getType() ==
				((VariableDeclarationStatement) copy.getTrueBranch()).getType());
		assert(((VariableDeclarationStatement) orig.getFalseBranch()).getName().equals(
				((VariableDeclarationStatement) copy.getFalseBranch()).getName()));
		assert(((VariableDeclarationStatement) orig.getFalseBranch()).getType() ==
				((VariableDeclarationStatement) copy.getFalseBranch()).getType());
	}

}
