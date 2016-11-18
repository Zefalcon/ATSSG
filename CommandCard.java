package ATSSG;

import java.awt.GridLayout;
import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ATSSG.Player.Player;

public class CommandCard extends UIContainer<CommandButton> {

	//Variables
	
	protected CommandButton[] buttons;
	
	//Constructors
	
	public CommandCard(Collection<CommandButton> content, int width, int height, Player owner, MainMap holder) {
		super(content, width, height, owner);
		view = new JPanel();
		view.setLayout(new GridLayout(3,3));
		buttons = new CommandButton[9];
		for (int i = 0; i < 9; i++) {
			buttons[i] = new CommandButton(new ImageIcon(Paths.get("src/ATSSG/Art/BlankLabel.png").toString()), owner);
			view.add(buttons[i].getView());
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