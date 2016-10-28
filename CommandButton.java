package ATSSG;

import javax.swing.Icon;

public abstract class CommandButton extends Button {
	
	//Variables
	protected String hoverText;
	protected Entity entity;
	protected MainMap holder;
	
	//Methods
	public CommandButton(Icon icon, String hoverText, Entity entity, Player owner, MainMap holder) {
		super(icon, owner);
		this.hoverText = hoverText;
		this.entity = entity;
		this.holder = holder; //flag - may cause terrible problems when building the entire project, see Unit's collection of buttons
	}
	
	public void isHovered(){
		
	}

}
