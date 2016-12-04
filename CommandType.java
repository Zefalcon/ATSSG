package ATSSG;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
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
	
	public Icon getIcon() {
		return icon;
	}
	
	public static void setIconSizes(int width, int height) throws IOException {
		IDLE.icon = new ImageIcon(ImageIO.read(new File(
				Paths.get("src/ATSSG/Art/DemoIdle.png").toString())).getScaledInstance(width, height, Image.SCALE_SMOOTH));
		MOVE.icon = new ImageIcon(ImageIO.read(new File(
				Paths.get("src/ATSSG/Art/DemoMove.png").toString())).getScaledInstance(width, height, Image.SCALE_SMOOTH));
		ATTACK.icon = new ImageIcon(ImageIO.read(new File(
				Paths.get("src/ATSSG/Art/DemoAttack.png").toString())).getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
}
