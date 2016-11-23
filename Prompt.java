package ATSSG;

import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Prompt extends Overlay {
	
	//Variables
	protected String message;
	protected JButton goTo;

	//Methods
	public Prompt(Collection<Object> content, int width, int height) {
		super(content, width, height);
		//view = new JOptionPane();
		//Given how JOptionPane actually works this class is likely redundant and destined for purging.
	}
}
