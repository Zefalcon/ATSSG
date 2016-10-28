package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import ATSSG.Player.Player;

public class MoveButton extends CommandButton {

	//Fields
	
	//Perhaps these buttons require an int field that lets an Iterator order them.
	
	//Methods
	public MoveButton(Icon icon, String hoverText, Unit unit, Player owner, MainMap holder) {
		super(icon, hoverText, unit, owner, holder);
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if not left click do nothing
				
				//wait and detect a right click on the MainMap
				//issue the unit a move action with the relevant info
				
				//possibly we have a reference to MainMap (in cmdbutton), and MainMap has a heldCommand field (of type UnitAction) 
				//that interacts with right-click cases in ActionListeners?
				//That is also where shift-queueing actions support would go
				
				//clicktype check
				holder.setHeldCommand(CommandType.MOVE);
				holder.setSelectedEntity(unit);
			}
		});
	}
	
	//Methods
	
	
}
