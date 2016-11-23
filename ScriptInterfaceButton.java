package ATSSG;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Script.ScriptInterface;

public class ScriptInterfaceButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Methods
	public ScriptInterfaceButton(int width, int height, final ScriptInterface si) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoScriptUI.png").toString()));
		this.setPreferredSize(new Dimension(width, height));
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				si.getView().setVisible(true);
			}
		});
		this.setEnabled(false);
	}
}
