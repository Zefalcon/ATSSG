package ATSSG.Entities;

import ATSSG.Cell;
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
        Player player = new HumanPlayer(null,new ArrayList<Entity>(), null);
        Cell cell = new Cell(TerrainType.GRASS,null,null,0,0);
        Entity e = new Unit(UnitType.Soldier,player,cell);
        e.doDamage(3);
        assertEquals(Math.max(0,UnitType.Soldier.maxHP-3), e.getHitPoints());
    }

    @Test
    public void kill() throws Exception {
        Player player = new HumanPlayer(null,new ArrayList<Entity>(),null);
        Cell cell = new Cell(TerrainType.GRASS,null,null,0,0);
        Entity e = new Unit(UnitType.Soldier,player,cell);
        e.doDamage(30);
        assertFalse(player.getEntities().contains(e));
    }

}