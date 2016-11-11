package ATSSG;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Collection;

import ATSSG.Player.Player;

public abstract class UIContainer<T> {
	
	//Variables
	protected Container view;
	protected Collection<T> content;
	protected Dimension size;
	protected Player owner;
	
	public UIContainer(Collection<T> content, int width, int height, Player owner) {
		this.content = content;
		this.size = new Dimension(width, height);
		this.owner = owner;
		view = null;
	}
	
	public Container getView() {return view;}
	public Collection<T> getContent() {return content;}
	public Dimension getSize(){return size;}
	public Player getOwner() {return owner;}
}
