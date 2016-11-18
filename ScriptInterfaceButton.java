package ATSSG;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;
import ATSSG.Script.ScriptInterface;

public class ScriptInterfaceButton extends Button {

	//Methods
	public ScriptInterfaceButton(int width, int height, Player owner, ScriptInterface si) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoScriptUI.png").toString()) , owner);
		gooeyButton.setPreferredSize(new Dimension(width, height));
		gooeyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				si.getView().setVisible(true);
			}
		});
		gooeyButton.setEnabled(false);
	}
}
