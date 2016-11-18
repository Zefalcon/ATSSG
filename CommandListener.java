package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ATSSG.Entities.Entity;
import ATSSG.Script.ScriptInterface;

public class CommandListener implements ActionListener {

	protected Entity entity;
	protected MainMap mainMap;
	protected CommandType cmd;
	protected ScriptInterface si;
	
	public CommandListener(Entity entity, CommandType cmd, MainMap mainMap, ScriptInterface si) {
		this.entity = entity;
		this.cmd = cmd;
		this.mainMap = mainMap;
		this.si = si;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (si.getView().isVisible() == true) {return;}
		if (cmd == CommandType.IDLE) {
			//entity.setAction(new IdleAction());
		} else {
			mainMap.setHeldCommand(cmd);
			mainMap.setHeldEntity(entity);
		}
	}
}
