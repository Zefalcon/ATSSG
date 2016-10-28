package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;

public class EndTurnButton extends Button {

	//Fields
	
	//Constructors
	
	public EndTurnButton(Player owner, Collection<Player> computers, MainMap holder) {
		super(new ImageIcon("D:/James/Documents/Eclipse/Workspace/ATSSG/src/ATSSG/Art/DemoEndTurn.png"), owner);
		//boolean prompted = false;
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//necessary to check type of action?
				//if (no prompts are open && the unit queue is empty && ! prompted)
					owner.executeAll();
					//iterator on computer players
					/*if (computers != null) {
						Iterator<Player> k = computers.iterator();
						Player ai;
						while (k.hasNext()) {
							ai = k.next();
							ai.executeAll();
						}
					}*/
					holder.updateView(0, 10, 0, 10); //flag arbitrary numbers
				//else generate an Are You Sure? prompt and set prompted = true
			}
		});
	}
	
	//Methods
}
