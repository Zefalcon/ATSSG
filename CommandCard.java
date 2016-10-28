package ATSSG;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JWindow;

import ATSSG.Player.Player;

public class CommandCard extends UIContainer<CommandButton> {
	
	//Variables
	
	//Gooey Object
	protected JWindow view;

	//Constructors
	
	public CommandCard(Collection<CommandButton> content, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner, MainMap holder) {
		super(content, xLoc, yLoc, width, height, displayLevel, owner);
		view = new JWindow();
		view.setLayout(new GridLayout(4,4));
		int numButtons = 0;
		if (content != null) {
			for(CommandButton b : content) {
				b.setHolder(holder);
				view.add(b.getGooey());
				numButtons++;
			}
		}
		while (numButtons < 16) {
			view.add(new JButton());
			numButtons++;
		}
		view.setBounds(xLoc, yLoc, width, height);
		view.setVisible(true);
	}
	
	//Methods
	
	/*public static void main(String[] args) {
		new CommandCard(null, new Layout(), 0, 0, 300, 300, 0, new Player());
	}*/
	
	public void updateCard(Collection<Button> content) {
		view.setLayout(new GridLayout(4,4));
		int numButtons = 0;
		if (content != null) {
			Iterator<Button> i = content.iterator();
			Button trav;
			while (i.hasNext()) {
				trav = i.next();
				view.add(trav.getGooey());
				numButtons++;
			}
		}
		while (numButtons < 16) {
			view.add(new JButton());
			numButtons++;
		}
		view.setBounds(xLoc, yLoc, width, height);
	}
}
