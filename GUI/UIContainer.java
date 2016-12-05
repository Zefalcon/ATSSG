package ATSSG.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Collection;

public abstract class UIContainer<T> {
	
	//Variables
	protected Container view;
	protected Collection<T> content;
	protected Dimension size;
	
	public UIContainer(Collection<T> content, int width, int height) {
		this.content = content;
		this.size = new Dimension(width, height);
		view = null;
	}
	
	public Container getView() {return view;}
	public Collection<T> getContent() {return content;}
	public Dimension getSize(){return size;}
}
