package ATSSG.Entities;

import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;
import ATSSG.Cell;
import ATSSG.GameMap;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zefal on 10/27/2016.
 */
public class UnitTest {
    @Test
    public void attack() throws Exception {
        //Range currently 1 cell
        Player player = new HumanPlayer(null,new ArrayList<Entity>(),null);
        Unit a = new Unit(UnitType.Soldier,player,new Cell(TerrainType.GRASS, null,null,0,0));
        Unit b = new Unit(UnitType.Soldier,player,new Cell(TerrainType.GRASS, null,null,1,0));
        assertTrue(a.canAttack(b));
        a.attack(b);
        assertEquals(Math.max(0,UnitType.Soldier.maxHP-UnitType.Soldier.aDamage), b.getHitPoints());
    }

    @Test
    public void move() throws Exception {
    	GameMap gm = new GameMap(new File("src/ATSSG/Maps/empty.map"));
        Player player = new HumanPlayer(null,new ArrayList<Entity>(),null);
        Cell a = gm.getCell(0, 0);
        Cell b = gm.getCell(1, 0);
        Unit u = new Unit(UnitType.Soldier, player, a);
        u.move(b);
        assertFalse(a.getOccupyingEntities().contains(u));
        assertTrue(b.getOccupyingEntities().contains(u));
    }

    @Test
    public void build() throws Exception {
        assertTrue(true);
    }

    @Test
    public void deposit() throws Exception {
        assertTrue(true);
    }

    @Test
    public void harvest() throws Exception {
        assertTrue(true);
    }

}