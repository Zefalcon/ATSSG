package ATSSG;
import javax.swing.Icon;

public abstract class Button {
	
	//Variables
	protected Icon icon;
	
	//Methods
	public Button(Icon icon) {
		this.icon = icon;
	}
	
	public abstract void clicked();

}
