package ATSSG;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameMapTest {
	
	private GameMap testMap;
	
	@Before
	public void createMap(){
		testMap = new GameMap();
	}
	
	@Test
	public void checkAdjCells(){
		assertNull(testMap.getCell(0, -1));
		assertNull(testMap.getCell(0, 11));
		assertEquals(testMap.getCell(5, 5).getX(), 5);
		assertEquals(testMap.getCell(5, 5).getY(), 5);
		assertEquals(testMap.getCell(0, 0).getAdjacent().size(), 3);
		assertEquals(testMap.getCell(0, 1).getAdjacent().size(), 5);
		assertEquals(testMap.getCell(10, 10).getAdjacent().size(), 3);
		assertEquals(testMap.getCell(10, 8).getAdjacent().size(), 5);
		assertEquals(testMap.getCell(5, 5).getAdjacent().size(), 8);
	}
	
	@Test
	public void checkPlayers(){
		assertEquals(testMap.getPlayers().size(), 2);
	}
	
	@Test
	public void checkTerrain(){
		assertEquals(testMap.getCell(5, 5).getTerrainType(), TerrainType.GRASS);
		assertEquals(testMap.getCell(3, 4).getTerrainType(), TerrainType.GRASS);
	}
	
	@Test
	public void checkUnits(){
		assertEquals(testMap.getCell(3, 4).getOccupyingEntities().size(), 1);
		assertEquals(testMap.getCell(5, 4).getOccupyingEntities().size(), 0);
	}

}