package ATSSG.Player.AI;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import ATSSG.Cell;
import ATSSG.GameMap;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Unit;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;

public class MoveMetaTest {

	@Test
	public void test() throws IOException {
		GameMap gm = new GameMap(new File("src/ATSSG/Maps/empty.map"));
		Unit u = new Unit(UnitType.Soldier, null, gm.getCell(3, 4));
		MoveAction m = (MoveAction) new MoveMeta(gm.getCell(1, 2), u).nextAction();
		assertEquals(1, Cell.distance(gm.getCell(1, 2), m.getEndPoint()));
		m = (MoveAction) new MoveMeta(gm.getCell(8, 7), u).nextAction();
		assertEquals(2, Cell.distance(gm.getCell(8, 7), m.getEndPoint()));
		m = (MoveAction) new MoveMeta(gm.getCell(3, 4), u).nextAction();
		assertNull(m);
	}

}
