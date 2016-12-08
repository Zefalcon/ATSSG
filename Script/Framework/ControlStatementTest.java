package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import ATSSG.Cell;
import ATSSG.Entities.Unit;
import ATSSG.Enums.CommandType;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;

public class ControlStatementTest {

	@Test
	public void testExecute() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		Block b1 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var1", Double.class));
		b1.addAtEnd(new ActionStatement(CommandType.IDLE, new ArrayList<String>()));
		b1.addAtEnd(new VariableDeclarationStatement("var2", Boolean.class));
		Block b2 = new Block();
		b2.addAtEnd(new VariableDeclarationStatement("var3", Double.class));
		ControlStatement c1 = new ControlStatement(b1.copy(), b2.copy(), "true");
		assertFalse(s.getHeap().containsKey("var1"));
		assertFalse(s.getHeap().containsKey("var2"));
		assertFalse(s.getHeap().containsKey("var3"));
		c1.execute(s);
		assertTrue(s.getHeap().containsKey("var1"));
		assertFalse(s.getHeap().containsKey("var2"));
		assertFalse(s.getHeap().containsKey("var3"));
		c1.execute(s);
		assertTrue(s.getHeap().containsKey("var1"));
		assertTrue(s.getHeap().containsKey("var2"));
		assertFalse(s.getHeap().containsKey("var3"));
		s = new Script(u);
		ControlStatement c2 = new ControlStatement(b1.copy(), b2.copy(), "false");
		assertFalse(s.getHeap().containsKey("var1"));
		assertFalse(s.getHeap().containsKey("var2"));
		assertFalse(s.getHeap().containsKey("var3"));
		c2.execute(s);
		assertFalse(s.getHeap().containsKey("var1"));
		assertFalse(s.getHeap().containsKey("var2"));
		assertTrue(s.getHeap().containsKey("var3"));
	}

	@Test
	public void testStatementDone() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		Block b1 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var1", Double.class));
		b1.addAtEnd(new ActionStatement(CommandType.IDLE, new ArrayList<String>()));
		b1.addAtEnd(new VariableDeclarationStatement("var2", Boolean.class));
		Block b2 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var3", Double.class));
		ControlStatement c1 = new ControlStatement(b1.copy(), b2.copy(), "true");
		assertFalse(c1.statementDone());
		c1.execute(s);
		assertFalse(c1.statementDone());
		c1.execute(s);
		assertTrue(c1.statementDone());
		ControlStatement c2 = new ControlStatement(b1.copy(), b2.copy(), "false");
		assertFalse(c2.statementDone());
		c2.execute(s);
		assertTrue(c2.statementDone());
		ControlStatement c3 = new ControlStatement(null, null, "false");
		assertFalse(c3.statementDone());
		c3.execute(s);
		assertTrue(c3.statementDone());
		
		
	}

	@Test
	public void testCopy() throws ScriptError {
		Statement s1 = new VariableDeclarationStatement("var1", Double.class);
		Statement s2 = new VariableDeclarationStatement("var2", Boolean.class);
		ControlStatement orig = new ControlStatement(s1, s2, "true");
		ControlStatement copy = (ControlStatement) orig.copy();
		assertNotSame(orig, copy);
		assertNotSame(orig.getCondition(), copy.getCondition());
		assertTrue(orig.getCondition().equals(copy.getCondition()));
		assertNotSame(orig.getTrueBranch(), copy.getTrueBranch());
		assertTrue(((VariableDeclarationStatement) orig.getTrueBranch()).getName().equals(
				((VariableDeclarationStatement) copy.getTrueBranch()).getName()));
		assertEquals(((VariableDeclarationStatement) orig.getTrueBranch()).getType(), 
				((VariableDeclarationStatement) copy.getTrueBranch()).getType());
		assertTrue(((VariableDeclarationStatement) orig.getFalseBranch()).getName().equals(
				((VariableDeclarationStatement) copy.getFalseBranch()).getName()));
		assertEquals(((VariableDeclarationStatement) orig.getFalseBranch()).getType(), 
				((VariableDeclarationStatement) copy.getFalseBranch()).getType());
	}

}
