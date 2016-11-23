package ATSSG;

import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TerrainCard extends UIContainer<TerrainType> {

	//Variables
	
	protected TerrainType terrain;
	
	protected JLabel terrView;
	
	//Constructors
	
	public TerrainCard(Collection<TerrainType> content, int width, int height) {
		super(content, width, height);
		this.terrain = content.iterator().next();
		view = new JPanel();
		view.setPreferredSize(getSize());
		terrView = new JLabel(terrain.description, terrain.image, SwingConstants.CENTER);
		terrView.setVerticalTextPosition(SwingConstants.BOTTOM);
		terrView.setHorizontalTextPosition(SwingConstants.CENTER);
		view.add(terrView);
		view.setVisible(true);
	}
	
	public void update(TerrainType terrain) {
		if (this.terrain != terrain) {
			this.terrain = terrain;
			terrView.setIcon(terrain.image);
			terrView.setText(terrain.description);
		}
	}
}
