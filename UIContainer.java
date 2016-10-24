package ATSSG;
import java.util.Collection;

public class UIContainer<T> {
	
	//Variables
	protected Collection<T> content;
	protected Layout card;
	protected int xLoc;
	protected int yLoc;
	protected int width;
	protected int height;
	protected int displayLevel;
	
	public UIContainer(Collection<T> content, Layout card, int xLoc, int yLoc,
			int width, int height, int displayLevel) {
		this.content = content;
		this.card = card;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.width = width;
		this.height = height;
		this.displayLevel = displayLevel;
	}
}
