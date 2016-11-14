package ATSSG;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ATSSG.Player.Player;

public class MenuButton extends Button {

	public MenuButton(Player owner, JPanel paneSwitcher) {
		super(null, owner);
		gooeyButton = new JButton(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuButton.png").toString()));
		gooeyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) paneSwitcher.getLayout();
				cl.previous(paneSwitcher);
			}
		});
	}
	
	public void clicked() {
		
	}
}
