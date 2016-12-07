package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetVariableStatementTest {

	@Test
	public void testExecute() throws ScriptError {
		Script s = new Script(null);
		new VariableDeclarationStatement("var1", Double.class).execute(s);
		new SetVariableStatement("var1", "1").execute(s);
		assertEquals((Double) s.getHeap().get("var1"), (Double) 1.0);
		new SetVariableStatement("var1", "5").execute(s);
		assertEquals((Double) s.getHeap().get("var1"), (Double) 5.0);
		new VariableDeclarationStatement("var2", Boolean.class).execute(s);
		new SetVariableStatement("var2", "true").execute(s);
		assertTrue((Boolean) s.getHeap().get("var2"));
		try {
			new SetVariableStatement("var3", "true").execute(s);
			fail();
		} catch (ScriptError e) {
		}
	}

	@Test
	public void testStatementDone() throws ScriptError {
		Script s = new Script(null);
		new VariableDeclarationStatement("var1", Double.class).execute(s);
		SetVariableStatement set = new SetVariableStatement("var1", "1");
		set.execute(s);
		assertTrue(set.statementDone());
	}
	
	@Test
	public void testCopy() {
		SetVariableStatement orig = new SetVariableStatement("a", "1");
		SetVariableStatement copy = (SetVariableStatement) orig.copy();
		assertEquals(orig.getName(), copy.getName());
		assertEquals(orig.getValue(), copy.getValue());
		assertNotSame(orig, copy);
	}

}
