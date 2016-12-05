package ATSSG.GUI;

import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ATSSG.Cell;
import ATSSG.Enums.TerrainType;

public class TerrainCard extends UIContainer<Cell> {

	//Variables
	
	protected Cell cell;
	
	protected JLabel terrView;
	
	//Constructors
	
	public TerrainCard(Collection<Cell> content, int width, int height) {
		super(content, width, height);
		
		if (content == null) {
			cell = new Cell(TerrainType.VOID, null, null, 0, 0);
		} else {
			this.cell = content.iterator().next();
		}
		view = new JPanel();
		view.setPreferredSize(getSize());
		terrView = new JLabel(cell.getTerrainType().description, cell.getTerrainDIcon(), SwingConstants.CENTER);
		terrView.setVerticalTextPosition(SwingConstants.BOTTOM);
		terrView.setHorizontalTextPosition(SwingConstants.CENTER);
		view.add(terrView);
		view.setVisible(true);
	}
	
	public void update(Cell c) {
		this.cell = c;
		terrView.setIcon(cell.getTerrainDIcon());
		terrView.setText(cell.getTerrainType().getDescription());
	}
}
