package ATSSG;

import java.util.Collection;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ATSSG.Player.Player;

public class ResourceCard extends UIContainer<Integer>{
	
	//Variables
	protected Collection<ResourceType> resources;
	protected Collection<Icon> pics;
	
	//Constructors
	public ResourceCard(Collection<Integer> quantities, Collection<Icon> pics, int width, int height, Player owner) {
		super(quantities, width, height, owner);
		this.pics = pics;
		view = new JPanel();
		view.add(new JLabel());
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	//Methods
	public void update(int resource, int transaction){
		
	}

}
