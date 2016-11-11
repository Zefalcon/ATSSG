package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;

public class EndTurnButton extends Button {

	//Fields
	
	//Constructors
	
	public EndTurnButton(final Player owner, final Collection<Player> computers, final Gooey holder) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoEndTurn.png").toString()), owner);
		//boolean prompted = false;
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
	
	//Methods
}
