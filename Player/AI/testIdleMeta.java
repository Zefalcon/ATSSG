package ATSSG.Player.AI;

import static org.junit.Assert.*;

import org.junit.Test;

public class testIdleMeta {

	@Test
	public void testNextAction() {
		MetaAction idle = new IdleMeta();
		assertNull(idle.nextAction());
	}

	@Test
	public void testIsDone() {
		MetaAction idle = new IdleMeta();
		assert(idle.isDone());
	}

}