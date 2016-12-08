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

public class LoopStatementTest {

	@Test
	public void testExecute() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		new VariableDeclarationStatement("var1", Double.class).execute(s);
		new SetVariableStatement("var1", "1").execute(s);
		Block b = new Block();
		b.addAtEnd(new SetVariableStatement("var1", "var1+1"));
		LoopStatement l1 = new LoopStatement(b.copy(), "var1 < 3");
		assertEquals((Double) 1.0, (Double) s.getHeap().get("var1"));
		l1.execute(s);
		assertEquals((Double) s.getHeap().get("var1"), (Double) 3.0);
		b.addAtEnd(new ActionStatement(CommandType.IDLE, new ArrayList<String>()));
		LoopStatement l2 = new LoopStatement(b.copy(), "var1 < 5");
		l2.execute(s);
		assertEquals((Double) s.getHeap().get("var1"), (Double) 4.0);
		l2.execute(s);
		assertEquals((Double) s.getHeap().get("var1"), (Double) 5.0);
		l2.execute(s);
		assertEquals((Double) s.getHeap().get("var1"), (Double) 5.0);
		LoopStatement l3 = new LoopStatement(b.copy(), "var1 < 5");
		l3.execute(s);
		assertEquals((Double) s.getHeap().get("var1"), (Double) 5.0);
	}

	@Test
	public void testStatementDone() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		new VariableDeclarationStatement("var1", Double.class).execute(s);
		new SetVariableStatement("var1", "1").execute(s);
		Block b = new Block();
		b.addAtEnd(new SetVariableStatement("var1", "var1+1"));
		LoopStatement l1 = new LoopStatement(b.copy(), "var1 < 3");
		assertFalse(l1.statementDone());
		l1.execute(s);
		assertTrue(l1.statementDone());
		b.addAtEnd(new ActionStatement(CommandType.IDLE, new ArrayList<String>()));
		LoopStatement l2 = new LoopStatement(b.copy(), "var1 < 5");
		assertFalse(l2.statementDone());
		l2.execute(s);
		assertFalse(l2.statementDone());
		l2.execute(s);
		assertFalse(l2.statementDone());
		l2.execute(s);
		assertTrue(l2.statementDone());
	}

	@Test
	public void testCopy() throws ScriptError {
		Block b = new Block();
		Statement s1 = new VariableDeclarationStatement("var1", Double.class);
		b.addStatement(s1, 0);
		LoopStatement l1 = new LoopStatement(b, "true");
		LoopStatement l2 = (LoopStatement) l1.copy();
		assertNotSame(l1, l2);
		assertNotSame(l1.getOriginalbody(), l2.getOriginalbody());
		assertEquals(l1.getOriginalbody().getClass(), l2.getOriginalbody().getClass());
		assertNotSame(l1.getCondition(), l2.getCondition());
		assertTrue(l1.getCondition().equals(l2.getCondition()));
	}

}
