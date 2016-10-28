package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;
import ATSSG.Entities.Unit;

public class MoveButton extends CommandButton {

	//Fields
	
	//Perhaps these buttons require an int field that lets an Iterator order them.
	
	//Methods
	public MoveButton(final Unit unit, Player owner) {
		super(new ImageIcon("D:/James/Documents/Eclipse/Workspace/ATSSG/src/ATSSG/Art/DemoMove.png"),
				"Move Command Hover Text", unit, owner);
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
				holder.setHeldEntity(unit);
			}
		});
	}
	
	//Methods
	
	
}