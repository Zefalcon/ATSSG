package ATSSG;
import javax.swing.Icon;

public class UnitButton extends Button {
	
	//Variables
	protected Icon visual;
	protected Unit reference;

	//Methods
	public UnitButton(Icon icon, Unit reference) {
		super(icon);
		this.reference = reference;
	}
	
	public void clicked() {
		
	}
}
