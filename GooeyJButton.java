package ATSSG;

import javax.swing.Icon;
import javax.swing.JButton;

public class GooeyJButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Cell locus;

	/*public GooeyJButton() {
		super();
		locus = null;
	}*/

	public GooeyJButton(Icon icon, Cell locus) {
		super(icon);
		this.locus = locus;
	}

	/*public GooeyJButton(String text) {
		super(text);
	}

	public GooeyJButton(Action a) {
		super(a);
	}

	public GooeyJButton(String text, Icon icon) {
		super(text, icon);
	}*/

	public Cell getCell() {
		return locus;
	}
}
