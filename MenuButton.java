package ATSSG;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuButton(int width, int height, final JPanel paneSwitcher) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuButton.png").toString()));
		this.setPreferredSize(new Dimension(width, height));
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) paneSwitcher.getLayout();
				cl.previous(paneSwitcher);
			}
		});
	}
}
