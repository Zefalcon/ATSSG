package ATSSG.GUI;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ATSSG.Cell;

public class GooeyJButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected Cell locus;

	/*public GooeyJButton() {
		super();
		locus = null;
	}*/

	public GooeyJButton(Icon icon, Cell locus) {
		super(icon);
		this.locus = locus;
		LineBorder b = new LineBorder(Color.WHITE);
		setBorder(b);
		setBorderPainted(false);
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
	
	public void toggleSelected() {
		setBorderPainted(!isBorderPainted());
	}
}
