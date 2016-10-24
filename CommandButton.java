package ATSSG;

import javax.swing.Icon;

public abstract class CommandButton extends Button {
	
	//Variables
	protected String hoverText;
	
	//Methods
	public CommandButton(Icon icon, String hoverText) {
		super(icon);
		this.hoverText = hoverText;
	}
	
	public void isHovered(){
		
	}

}
