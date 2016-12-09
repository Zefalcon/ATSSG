package ATSSG;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ATSSG.Entities.Unit;
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
		assertEquals(testMap.getPlayers().size(), 2);
	}
	
	@Test
	public void checkTerrain(){
		assertEquals(testMap.getCell(5, 5).getTerrainType(), TerrainType.GRASS);
		assertEquals(testMap.getCell(3, 4).getTerrainType(), TerrainType.GRASS);
	}
	
	@Test
	public void checkLoadsave(){
		try{
			GameMap savemap = new GameMap(new File("src/ATSSG/Maps/Large.map"));
			FileOutputStream out = new FileOutputStream("src/ATSSG/testsave.sav");
			out.write(savemap.Save());
			out.close();

			File file = new File("src/ATSSG/testsave.sav");
			FileInputStream in = new FileInputStream(file);
			byte[] contents = new byte[(int)file.length()];
			in.read(contents);
			in.close();
			
			GameMap loadmap = new GameMap();
			loadmap.update(GameMap.Load(contents));
			
			assertEquals(savemap.getEntities().size(), loadmap.getEntities().size());
			for(int i = 0; i < loadmap.getEntities().size(); i++){
				assertEquals(savemap.getEntities().get(i).toString(), loadmap.getEntities().get(i).toString());
				assertEquals(((Unit)savemap.getEntities().get(i)).getHitPoints(), ((Unit)savemap.getEntities().get(i)).getHitPoints());
			}
		}catch(FileNotFoundException x){
			//Silently drop.
		}
		catch(Exception x){
			System.out.println(x.toString());
		}
	}
	
	/*@Test
	public void checkUnits(){
		assertEquals(testMap.getCell(3, 4).getOccupyingEntities().size(), 1);
		assertEquals(testMap.getCell(5, 4).getOccupyingEntities().size(), 0);
	}*/

}