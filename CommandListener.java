package ATSSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ATSSG.Entities.Entity;

public class CommandListener implements ActionListener {

	protected Entity entity;
	protected MainMap mainMap;
	protected CommandType cmd;
	
	public CommandListener(Entity entity, CommandType cmd, MainMap mainMap) {
		this.entity = entity;
		this.cmd = cmd;
		this.mainMap = mainMap;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (cmd == CommandType.IDLE) {
			//entity.setAction(new IdleAction());
		} else {
			mainMap.setHeldCommand(cmd);
			mainMap.setHeldEntity(entity);
		}
	}
}
