package ATSSG;
import ATSSG.Entities.Unit;

import java.util.Collection;

public class UnitQueue extends UIContainer<UnitButton> {
	
	//Variables
	protected Collection<UnitButton> units;
	protected Collection<UnitButton> displayedUnits;
	
	//Constructos
	public UnitQueue(Collection<UnitButton> units, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(units, card, xLoc, yLoc, width, height, displayLevel);
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
