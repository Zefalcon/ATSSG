package ATSSG;

import java.nio.file.Paths;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum CommandType {
	
	IDLE(new ImageIcon(Paths.get("src/ATSSG/Art/DemoIdle.png").toString())),
	MOVE(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMove.png").toString())),
	ATTACK(new ImageIcon(Paths.get("src/ATSSG/Art/DemoAttack.png").toString()));
	
	public Icon icon;
	
	private CommandType(Icon icon) {
		this.icon = icon;
	}
}
