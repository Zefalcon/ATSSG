package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetVariableStatementTest {

	@Test
	public void testExecute() throws ScriptError {
		Script s = new Script(null);
		new VariableDeclarationStatement("var1", Double.class).execute(s);
		Statement set = new SetVariableStatement("var1", "1");
		set.execute(s);
		assert((Double) s.getHeap().get("var1") == 1.0);
		new VariableDeclarationStatement("var2", Boolean.class).execute(s);
		set = new SetVariableStatement("var2", "true");
		set.execute(s);
		assert((Boolean) s.getHeap().get("var2") == true);
		try {
			new SetVariableStatement("var3", "true").execute(s);
			assert(false);
		} catch (ScriptError e) {
			assert(true);
		}
	}

	@Test
	public void testStatementDone() throws ScriptError {
		Script s = new Script(null);
		new VariableDeclarationStatement("var1", Double.class).execute(s);
		SetVariableStatement set = new SetVariableStatement("var1", "1");
		set.execute(s);
		assert(set.statementDone());
	}
	
	@Test
	public void testCopy() {
		SetVariableStatement orig = new SetVariableStatement("a", "1");
		SetVariableStatement copy = (SetVariableStatement) orig.copy();
		assertEquals(orig.getName(), copy.getName());
		assertEquals(orig.getValue(), copy.getValue());
		assert(orig != copy);
	}

}
