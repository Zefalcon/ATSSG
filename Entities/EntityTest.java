package ATSSG.Entities;

import ATSSG.Cell;
import ATSSG.GameMap;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;
import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zefal on 10/27/2016.
 */
public class EntityTest {
    @Test
    public void doDamage() throws Exception {
        GameMap map = new GameMap();
        Player player = new HumanPlayer(null,new ArrayList<Entity>(),map);
        Cell cell = new Cell(TerrainType.GRASS,null,map,0,0);
        Entity e = new Unit(UnitType.Soldier,player,cell);
        e.doDamage(3);
        assertEquals(Math.max(0,UnitType.Soldier.maxHP-3), e.getHitPoints());
    }

    @Test
    public void kill() throws Exception {
        GameMap map = new GameMap();
        Player player = new HumanPlayer(null,new ArrayList<Entity>(),map);
        Cell cell = new Cell(TerrainType.GRASS,null,map,0,0);
        Entity e = new Unit(UnitType.Soldier,player,cell);
        e.doDamage(30);
        assertFalse(player.getEntities().contains(e));
    }

}