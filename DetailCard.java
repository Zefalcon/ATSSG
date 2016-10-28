package ATSSG;
import java.util.Collection;
import javax.swing.Icon;

import ATSSG.Player.Player;

public class DetailCard extends UIContainer<Cell> {
	
	//Variables
	protected Collection<Icon> selVisual;
	protected Collection<Collection<String>> selDescript;
	
	//Constructors
	public DetailCard(Collection<Cell> location, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner) {
		super(location, xLoc, yLoc, width, height, displayLevel, owner);
		setSelData(location);
	}
	
	//Methods
	public void update(Collection<Cell> sel) {
		setSelData(sel);
	}
	
	private void setSelData(Collection<Cell> sel) {
		//Some complicated invocation to set selVisual&selDescript based on the location Cells
		selVisual = null;//temporary
		selDescript = null;//temporary
	}
}
