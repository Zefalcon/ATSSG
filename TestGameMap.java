package ATSSG;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ATSSG.Enums.TerrainType;

public class TestGameMap {
	
	private GameMap testMap;
	
	@Before
	public void createMap() throws IOException{
		testMap = new GameMap(new File("src/ATSSG/Maps/empty.map"));
	}
	
	@Test
	public void checkAdjCells(){
		assertNull(testMap.getCell(0, -1));
		assertNull(testMap.getCell(0, 11));
		assertEquals(testMap.getCell(5, 5).getX(), 5);
		assertEquals(testMap.getCell(5, 5).getY(), 5);
		assertEquals(testMap.getCell(0, 0).getAdjacent().size(), 3);
		assertEquals(testMap.getCell(0, 1).getAdjacent().size(), 5);
		assertEquals(testMap.getCell(9, 9).getAdjacent().size(), 3);
		assertEquals(testMap.getCell(9, 7).getAdjacent().size(), 5);
		assertEquals(testMap.getCell(5, 5).getAdjacent().size(), 8);
	}
	
	@Test
	public void checkPlayers(){
		assertEquals(testMap.getPlayers().size(), 1);
	}
	
	@Test
	public void checkTerrain(){
		assertEquals(testMap.getCell(5, 5).getTerrainType(), TerrainType.GRASS);
		assertEquals(testMap.getCell(3, 4).getTerrainType(), TerrainType.GRASS);
	}
	
	/*@Test
	public void checkUnits(){
		assertEquals(testMap.getCell(3, 4).getOccupyingEntities().size(), 1);
		assertEquals(testMap.getCell(5, 4).getOccupyingEntities().size(), 0);
	}*/

}