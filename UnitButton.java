package ATSSG;
import javax.swing.Icon;

public class UnitButton extends Button {
	
	//Variables
	protected Icon visual;
	protected Unit reference;

	//Methods
	public UnitButton(Icon icon, Player owner, Unit reference) {
		super(icon, owner);
		this.reference = reference;
	}
}
