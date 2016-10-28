package ATSSG;
import java.util.Collection;

import ATSSG.Player.Player;

public class UnitQueue extends UIContainer<UnitButton> {
	
	//Variables
	protected Collection<UnitButton> units;
	protected Collection<UnitButton> displayedUnits;
	
	//Constructos
	public UnitQueue(Collection<UnitButton> units, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner) {
		super(units, xLoc, yLoc, width, height, displayLevel, owner);
		fillDisplayedUnits();
	}
	
	//Methods
	public void addAll() { 
		
	}
	
	public void remove(Unit instructed) {
		
	}
	
	private void fillDisplayedUnits() {
		
	}
}
