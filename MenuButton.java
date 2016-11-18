package ATSSG;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ATSSG.Player.Player;

public class MenuButton extends Button {

	public MenuButton(int width, int height, Player owner, final JPanel paneSwitcher) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuButton.png").toString()), owner);
		gooeyButton.setPreferredSize(new Dimension(width, height));
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
