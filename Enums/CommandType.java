package ATSSG.Enums;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum CommandType {
	
	VOID("", Paths.get("src/ATSSG/Art/BlankLabel.png").toString()),
	IDLE("Idle", Paths.get("src/ATSSG/Art/DemoIdle.png").toString().toString()),
	MOVE("Move", Paths.get("src/ATSSG/Art/DemoMove.png").toString().toString()),
	ATTACK("Attack", Paths.get("src/ATSSG/Art/DemoAttack.png").toString().toString());
	
	private Image image;
	public Icon icon;
	public String name;
	
	private CommandType(String name, String path) {
		try {
			this.name= name;
			image = ImageIO.read(new File(path));
			icon = new ImageIcon(path);
		} catch (IOException ioe) {
			System.out.println("Images not found for commands");
		}
	}
	
	public Icon getIcon() {return icon;}
	public String getName() {return name;}
	
	public static void setIconSizes(int width, int height) {
		VOID.icon = new ImageIcon(VOID.image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		IDLE.icon = new ImageIcon(IDLE.image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		MOVE.icon = new ImageIcon(MOVE.image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		ATTACK.icon = new ImageIcon(ATTACK.image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
}
