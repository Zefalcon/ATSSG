package ATSSG;

import javax.swing.Icon;

import ATSSG.Player.Player;
import ATSSG.Entities.Entity;

public abstract class CommandButton extends Button {
	
	//Variables
	protected String hoverText;
	protected Entity entity;
	protected MainMap holder;
	
	//Methods
	public CommandButton(Icon icon, String hoverText, Entity entity, Player owner) {
		super(null, owner);
		this.hoverText = hoverText;
		this.entity = entity;
		holder = null;
		this.gooeyButton = new GooeyJButton(icon, entity.getContainingCell());
	}
	
	public void setHolder(MainMap holder) {
		this.holder = holder;
	}
	
	public void isHovered(){
		
	}

}
