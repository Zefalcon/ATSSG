package ATSSG.GUI;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum CommandType {
	
	IDLE(Paths.get("src/ATSSG/Art/DemoIdle.png").toString().toString()),
	MOVE(Paths.get("src/ATSSG/Art/DemoMove.png").toString().toString()),
	ATTACK(Paths.get("src/ATSSG/Art/DemoAttack.png").toString().toString());
	
	private String path;
	private Image image;
	public Icon icon;
	
	private CommandType(String path) {
		this.path = path;
		image = null;
		icon = new ImageIcon(path);
	}
	
	public Icon getIcon() {
		return icon;
	}
	
	public static void populateImages() throws IOException {
		IDLE.image = ImageIO.read(new File(IDLE.path));
		MOVE.image = ImageIO.read(new File(MOVE.path));
		ATTACK.image = ImageIO.read(new File(ATTACK.path));
	}
	
	public static void setIconSizes(int width, int height) {
		IDLE.icon = new ImageIcon(IDLE.image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		MOVE.icon = new ImageIcon(MOVE.image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		ATTACK.icon = new ImageIcon(ATTACK.image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		}
}
