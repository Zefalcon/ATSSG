package ATSSG;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.ImageIcon;

import ATSSG.Player.Player;
import ATSSG.Player.AI.AIPlayer;

public class EndTurnButton extends Button {

	//Fields
	
	Gooey holder;
	GameMap gm;
	UnitQueue uq;
	Collection<AIPlayer> computers;
	Boolean prompted = false;
	
	//Constructors
	
	public EndTurnButton(int width, int height, final Player owner, final Collection<AIPlayer> computers, final Gooey holder, final GameMap gm,
			final UnitQueue uq) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoEndTurn.png").toString()), owner);
		this.holder = holder;
		this.computers = computers;
		this.gm = gm;
		this.uq = uq;
		gooeyButton.setSize(new Dimension(width, height));
	}
	
	//Methods
	
	public void updateComputers() {
		computers = gm.getComputers();
		for (ActionListener actlis : gooeyButton.getActionListeners()) {
			gooeyButton.removeActionListener(actlis);
		}
		gooeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateComputers();
				if (uq.isEmpty() && ! prompted)
					owner.executeAll();
					if (computers != null) {
						for (AIPlayer ai : computers) {
							ai.executeAll();
						}
					}
					holder.turnEndUpdate();
				//else generate an Are You Sure? prompt and set prompted = true
			}
		});
	}
}
