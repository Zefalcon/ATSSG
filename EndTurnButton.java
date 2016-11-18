package ATSSG;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.text.View;

import ATSSG.Player.Player;

public class EndTurnButton extends Button {

	//Fields
	
	Gooey holder;
	Collection<Player> computers;
	Boolean prompted = false;
	
	//Constructors
	
	public EndTurnButton(int width, int height, final Player owner, final Collection<Player> computers, final Gooey holder) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoEndTurn.png").toString()), owner);
		this.holder = holder;
		this.computers = computers;
		gooeyButton.setSize(new Dimension(width, height));
	}
	
	//Methods
	
	public void setComputers(Collection<Player> computers) {
		for (ActionListener actlis : gooeyButton.getActionListeners()) {
			gooeyButton.removeActionListener(actlis);
		}
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//necessary to check type of action?
				//if (no prompts are open && the unit queue is empty && ! prompted)
					owner.executeAll();
					//iterator on computer players
					if (computers != null) {
						Iterator<Player> k = computers.iterator();
						Player ai;
						while (k.hasNext()) {
							ai = k.next();
							ai.executeAll();
						}
					}
					holder.turnEndUpdate();
				//else generate an Are You Sure? prompt and set prompted = true
			}
		});
	}
}
