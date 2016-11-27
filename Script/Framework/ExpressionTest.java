package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void testGetDoubleValue() {
		Script s = new Script(null);
		assertEquals((Double) 1.0, Expression.getDoubleValue("1", s));
		assertEquals((Double) 5.0, Expression.getDoubleValue("2+3", s));
		assertEquals((Double) 71.0, Expression.getDoubleValue("100-29", s));
		assertEquals((Double) 6.0, Expression.getDoubleValue("2*3", s));
		assertEquals((Double) 7.0, Expression.getDoubleValue("21/3", s));
		assertEquals((Double) 13.0, Expression.getDoubleValue("2+3*4-5/5", s));
		assertEquals((Double) 1.0, Expression.getDoubleValue("(2+3)*(5-4)/5", s));
		assertEquals((Double) 30.0, Expression.getDoubleValue("(2+3)*(5*2-4)", s));
	}

	@Test
	public void testGetBooleanValue() {
		Script s = new Script(null);
		assertEquals(true, Expression.getBooleanValue("true", s));
		assertEquals(false, Expression.getBooleanValue("false", s));
		assertEquals(false, Expression.getBooleanValue("true && false", s));
		assertEquals(true, Expression.getBooleanValue("true && true", s));
		assertEquals(true, Expression.getBooleanValue("true && (false || true)", s));
		assertEquals(true, Expression.getBooleanValue("3 == 3", s));
		assertEquals(true, Expression.getBooleanValue("3 <= 3", s));
		assertEquals(false, Expression.getBooleanValue("3 < 3", s));
		assertEquals(true, Expression.getBooleanValue("3 >= 3", s));
		assertEquals(false, Expression.getBooleanValue("3 > 3", s));
		assertEquals(true, Expression.getBooleanValue("2 <= 3", s));
		assertEquals(true, Expression.getBooleanValue("2 < 3", s));
		assertEquals(false, Expression.getBooleanValue("2 >= 3", s));
		assertEquals(false, Expression.getBooleanValue("2 > 3", s));
		assertEquals(false, Expression.getBooleanValue("3 <= 2", s));
		assertEquals(false, Expression.getBooleanValue("3 < 2", s));
		assertEquals(true, Expression.getBooleanValue("3 >= 2", s));
		assertEquals(true, Expression.getBooleanValue("3 > 2", s));
		assertEquals(true, Expression.getBooleanValue("1<2 && (3*4==2 || 2/1==2)", s));
		assertEquals(true, Expression.getBooleanValue("1<(1+1) && (3*4==2 || 2/1==2)", s));
	}

}
