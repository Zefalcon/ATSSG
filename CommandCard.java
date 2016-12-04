package ATSSG;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CommandCard extends UIContainer<CommandButton> {

	//Variables
	
	protected CommandButton[] buttons;
	
	//Constructors
	
	public CommandCard(Collection<CommandButton> content, int width, int height, MainMap holder) throws IOException {
		super(content, width, height);
		view = new JPanel();
		view.setLayout(new GridLayout(3,3));
		buttons = new CommandButton[9];
		String blankLabelPath = Paths.get("src/ATSSG/Art/BlankLabel.png").toString();
		for (int i = 0; i < 9; i++) {
			buttons[i] = new CommandButton(new ImageIcon(ImageIO.read(
					new File(blankLabelPath)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
			view.add(buttons[i]);
		}
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	public void reset() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].reset();
		}
	}
	
	public CommandButton getCmdButton(int index) {return buttons[index];}
}