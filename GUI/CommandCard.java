package ATSSG.GUI;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;

public class CommandCard extends UIContainer<CommandButton> {

	//Variables
	
	protected CommandButton[] buttons;
	protected ImageIcon blankIcon;
	protected ImageIcon statIcon;
	protected JButton statButton;
	protected MainMap holder;
	
	//Constructors
	
	public CommandCard(Collection<CommandButton> content, int width, int height, MainMap holder) throws IOException {
		super(content, width, height);
		this.holder = holder;
		view = new JPanel();
		view.setLayout(new GridLayout(3,3));
		buttons = new CommandButton[8];
		String blankLabelPath = Paths.get("src/ATSSG/Art/BlankLabel.png").toString();
		blankIcon = new ImageIcon(ImageIO.read(
				new File(blankLabelPath)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH));
		statIcon = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/demoStats.png").toString())).getScaledInstance(
				(int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH));
		for (int i = 0; i < 8; i++) {
			buttons[i] = new CommandButton(new ImageIcon(ImageIO.read(
					new File(blankLabelPath)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
			view.add(buttons[i]);
		}
		statButton = new JButton(blankIcon);
		view.add(statButton);
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	public void reset() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].reset();
		}
	}
	
	public void resetStatLabel() {
		statButton.setIcon(blankIcon);
	}
	
	public void setStatLabel(final Entity e) {
		for (ActionListener al : statButton.getActionListeners()) {
			statButton.removeActionListener(al);
		}
		statButton.setIcon(statIcon);
		if (e instanceof Unit) {
			final Unit u = (Unit) e;
			statButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					holder.getGooey().getPrompts().createMessagePrompt("Unit Information", u.toString() + "\nOwner: " + 
				u.getOwner().toString() + "\nCurrent HP: " + u.getHitPoints() + "\nMaximum HP: " + u.getType().maxHP + 
				"\nAttack Range: " + u.getType().aRange + "\nAttack Damage: " + u.getType().aDamage + "\nMove Range: " + 
				u.getType().maxMoves, statIcon);
				}
			});
		}
		else {
			//It's a building, not implemented.
		}
	}
	
	public CommandButton getCmdButton(int index) {return buttons[index];}
}