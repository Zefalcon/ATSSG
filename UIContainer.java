package ATSSG;
import java.awt.Container;
import java.util.Collection;

public class UIContainer<T> {
	
	//Variables
	protected Container view;
	protected Collection<T> content;
	protected int xLoc;
	protected int yLoc;
	protected int width;
	protected int height;
	protected int displayLevel;
	protected Player owner;
	
	public UIContainer(Collection<T> content, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner) {
		this.content = content;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.width = width;
		this.height = height;
		this.displayLevel = displayLevel;
		this.owner = owner;
		view = null;
	}
	
	public Container getView() {
		return view;
	}
	
	public Collection<T> getContent() {
		return content;
	}
	
	public int getX() {
		return xLoc;
	}
	
	public int getY() {
		return yLoc;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getDisplayLevel() {
		return displayLevel;
	}
	
	public Player getOwner() {
		return owner;
	}
}
