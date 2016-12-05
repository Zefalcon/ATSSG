package ATSSG.GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuButton(int width, int height, final JPanel paneSwitcher) throws IOException {
		super(new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoMenuButton.png").toString())).getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		this.setPreferredSize(new Dimension(width, height));
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) paneSwitcher.getLayout();
				cl.previous(paneSwitcher);
			}
		});
	}
}
