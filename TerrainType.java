package ATSSG;
import java.nio.file.Paths;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public enum TerrainType {
	
	GRASS	("Grass", 1, "An open, grassy area.", new ImageIcon(Paths.get("src/ATSSG/Art/DemoTerrain.png").toString()));
	
	public String name;
	public int number;
	public String description;
	public Icon image;
	public JLabel label;
	
	TerrainType(String NAME, int NUMBER, String DESCRIPTION, Icon IMAGE){
		name = NAME;
		number = NUMBER;
		description = DESCRIPTION;
		image = IMAGE;
		label = new JLabel(IMAGE);
	}

	public Icon getImage() {return image;}
	public JLabel getLabel() {return label;}
	public int getNumber() {return number;}
	
	public static TerrainType getTerrainType(int number) {
		switch(number) {
		case 1:
			return GRASS;
		default:
			return GRASS; //FLAG: this is a disgusting hack to work around bad code in DetailCard.highestTerrains. Should return null;
		}
	}
}