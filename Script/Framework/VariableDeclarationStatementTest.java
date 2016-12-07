package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VariableDeclarationStatementTest {

	@Test
	public void testInitialization() throws ScriptError {
		VariableDeclarationStatement s = new VariableDeclarationStatement("var1", Double.class);
		assertEquals("var1", s.getName());
		assertEquals(Double.class, s.getType());
		s = new VariableDeclarationStatement("var2", Boolean.class);
		assertEquals("var2", s.getName());
		assertEquals(Boolean.class, s.getType());
		s = new VariableDeclarationStatement("A_B", Boolean.class);
		s = new VariableDeclarationStatement("a", Boolean.class);
		s = new VariableDeclarationStatement("a_$12J", Boolean.class);
		ArrayList<String> invalidNames = new ArrayList<String>();
		invalidNames.add("");
		invalidNames.add("2");
		invalidNames.add("_");
		invalidNames.add("$");
		invalidNames.add("a.b");
		invalidNames.add("a&b");
		invalidNames.add("a|b");
		invalidNames.add("a{b");
		invalidNames.add("a()b");
		for (String bad: invalidNames) {
			try {
				new VariableDeclarationStatement(bad, Double.class);
				fail(bad);
			} catch (ScriptError e) {
			}
		}
		
	}

	@Test
	public void testExecute() throws ScriptError {
		VariableDeclarationStatement v = new VariableDeclarationStatement("var1", Double.class);
		Script s = new Script(null);
		v.execute(s);
		assertTrue(s.getHeap().containsKey("var1"));
		assertEquals(s.getHeap().get("var1").getClass(), Double.class);
		v = new VariableDeclarationStatement("var2", Boolean.class);
		v.execute(s);
		assertEquals(s.getHeap().get("var2").getClass(), Boolean.class);
	}
	
	@Test
	public void testCopy() throws ScriptError {
		VariableDeclarationStatement orig = new VariableDeclarationStatement("var1", Double.class);
		VariableDeclarationStatement copy = (VariableDeclarationStatement) orig.copy();
		assertEquals(orig.getName(), copy.getName());
		assertEquals(orig.getType(), copy.getType());
		assertNotSame(orig, copy);
	}
	
	@Test
	public void testStatementDone() throws ScriptError {
		Statement s = new VariableDeclarationStatement("var1", Double.class);
		s.execute(new Script(null));
		assertTrue(s.statementDone());
	}
}
