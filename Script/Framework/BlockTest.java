package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ATSSG.Cell;
import ATSSG.Actions.IdleAction;
import ATSSG.Entities.Unit;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;

public class BlockTest {

	@Test
	public void testExecute() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		Block b1 = new Block();
		b1.addAtEnd(new VariableDeclarationStatement("var1", Double.class));
		b1.addAtEnd(new VariableDeclarationStatement("var2", Double.class));
		b1.execute(s);
		assert(s.getHeap().containsKey("var1"));
		assert(s.getHeap().containsKey("var2"));
		b1.addAtEnd(new ActionStatement(new IdleAction()));
		b1.addAtEnd(new VariableDeclarationStatement("var3", Double.class));
		Block b2 = new Block();
		b2.addAtEnd(b1);
		b2.addAtEnd(new ActionStatement(new IdleAction()));
		b2.addAtEnd(new VariableDeclarationStatement("var4", Double.class));
		b2.execute(s);
		assert(!s.getHeap().containsKey("var3"));
		assert(!s.getHeap().containsKey("var4"));
		b2.execute(s);
		assert(s.getHeap().containsKey("var3"));
		assert(!s.getHeap().containsKey("var4"));
		b2.execute(s);
		assert(s.getHeap().containsKey("var4"));
	}

	@Test
	public void testStatementDone() throws ScriptError, IOException {
		Unit u = new Unit(UnitType.Soldier, null, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Script s = new Script(u);
		Block b1 = new Block();
		assert(b1.statementDone());
		b1.addAtEnd(new VariableDeclarationStatement("var1", Double.class));
		b1.addAtEnd(new VariableDeclarationStatement("var2", Double.class));
		b1.execute(s);
		assert(b1.statementDone());
		b1.addAtEnd(new ActionStatement(new IdleAction()));
		b1.execute(s);
		assert(b1.statementDone());
		b1.addAtEnd(new ActionStatement(new IdleAction()));
		b1.addAtEnd(new VariableDeclarationStatement("var3", Double.class));
		Block b2 = new Block();
		b2.addAtEnd(b1);
		b2.addAtEnd(new ActionStatement(new IdleAction()));
		b2.addAtEnd(new VariableDeclarationStatement("var4", Double.class));
		b2.execute(s);
		assert(!b1.statementDone());
		assert(!b2.statementDone());
		b2.execute(s);
		assert(b1.statementDone());
		assert(!b2.statementDone());
		b2.execute(s);
		assert(b2.statementDone());
	}

	@Test
	public void testCopy() throws ScriptError {
		Block b1 = new Block();
		Statement s1 = new VariableDeclarationStatement("var1", Double.class);
		Statement s2 = new VariableDeclarationStatement("var2", Boolean.class);
		b1.addStatement(s1, 0);
		b1.addAtEnd(s2);
		Block b2 = (Block) b1.copy();
		assert(b1 != b2);
		assert(b1.getLines() != b2.getLines());
		assert(b1.getLines().get(0) != b2.getLines().get(0));
		assert(((VariableDeclarationStatement) b1.getLines().get(0)).getName().equals(
				((VariableDeclarationStatement) b2.getLines().get(0)).getName()));
		assert(((VariableDeclarationStatement) b1.getLines().get(0)).getType() == 
				((VariableDeclarationStatement) b2.getLines().get(0)).getType());
		assert(b1.getLines().get(1) != b2.getLines().get(1));
		assert(((VariableDeclarationStatement) b1.getLines().get(1)).getName().equals(
				((VariableDeclarationStatement) b2.getLines().get(1)).getName()));
		assert(((VariableDeclarationStatement) b1.getLines().get(1)).getType() 
				== ((VariableDeclarationStatement) b2.getLines().get(1)).getType());
	}

	@Test
	public void testAddAfter() throws ScriptError {
		Block b =new Block();
		Statement s1 = new VariableDeclarationStatement("var1", Double.class);
		Statement s2 = new VariableDeclarationStatement("var2", Double.class);
		Statement s3 = new VariableDeclarationStatement("var3", Double.class);
		Statement s4 = new VariableDeclarationStatement("var4", Double.class);
		b.addStatement(s1, 0);
		b.addAtEnd(s2);
		b.addAfter(s3, s1);
		b.addAfter(s4, null);
		List<Statement> lines = b.getLines();
		assertEquals(s4, lines.get(0));
		assertEquals(s1, lines.get(1));
		assertEquals(s3, lines.get(2));
		assertEquals(s2, lines.get(3));
	}

}
