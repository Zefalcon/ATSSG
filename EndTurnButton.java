package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class EndTurnButton extends Button {

	//Fields
	
	//Constructors
	
	public EndTurnButton(Icon icon, Player owner, Collection<Player> computers) {
		super(icon, owner);
		boolean prompted = false;
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//necessary to check type of action?
				//if (no prompts are open && the unit queue is empty && ! prompted)
					owner.executeTurn();
					//iterator on computer players
					if (computers != null) {
						Iterator<Player> k = computers.iterator();
						Player ai;
						while (k.hasNext()) {
							ai = k.next();
							ai.executeTurn();
						}
					}
				//else generate an Are You Sure? prompt and set prompted = true
			}
		});
	}
	
	//Methods
}
