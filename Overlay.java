package ATSSG;

import java.util.Collection;

public abstract class Overlay extends UIContainer<Object>{
	
	//Variables
	protected boolean visible;
	
	//Methods
	public Overlay(Collection<Object> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		super(content, card, xLoc, yLoc, width, height, displayLevel);
		visible = false;
	}
	
	public void alterSize(int width, int height){
		
	}
	
	public void isDragged(){
		
	}
	
	public void isClosed(){
		
	}
	
	public void isOpened(){
		
	}

}
