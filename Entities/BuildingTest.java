package ATSSG.Entities;

import ATSSG.Player.Player;
import ATSSG.Player.HumanPlayer;
import ATSSG.Cell;
import ATSSG.Enums.BuildingType;
import ATSSG.Enums.TerrainType;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zefal on 10/27/2016.
 */
public class BuildingTest {
    @Test
    public void validConstructionSquares() throws Exception {
        Building b = new Building(BuildingType.GENERIC,new HumanPlayer(null,new ArrayList<Entity>(),null),new Cell(TerrainType.GRASS,null,null,0,0));
        assertTrue(true); //Requires mocking up an actual game map, TODO
    }

    @Test
    public void build() throws Exception {
        assertTrue(true); //Requires mocking up an actual game map, TODO
    }

}