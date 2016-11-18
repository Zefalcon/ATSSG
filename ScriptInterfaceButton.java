package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Player.Player;
import ATSSG.Script.ScriptInterface;

public class ScriptInterfaceButton extends Button {

	//Methods
	public ScriptInterfaceButton(Player owner, ScriptInterface si) {
		super(null , owner);
		gooeyButton = new JButton(new ImageIcon(Paths.get("src/ATSSG/Art/DemoScriptUI.png").toString()));
		gooeyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				si.getView().setVisible(true);
			}
		});
	}
}
