package ATSSG;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.Player.Player;
import ATSSG.Player.AI.AIPlayer;

public class EndTurnButton extends JButton {

	//Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Gooey holder;
	protected final GameMap gameMap;
	protected final UnitQueue uq;
	protected final Boolean[] prompted = {false};
	
	//Constructors
	
	public EndTurnButton(int width, int height, final Gooey holder, final GameMap gameMap, final UnitQueue uq) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoEndTurn.png").toString()));
		this.holder = holder;
		this.uq = uq;
		this.gameMap = gameMap;
		this.setSize(new Dimension(width, height));
	}
	
	//Methods
	
	public void endTurn() {
		for (ActionListener actlis : this.getActionListeners()) {
			this.removeActionListener(actlis);
		}
		final Collection<Player> players = gameMap.getPlayers();
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uq.isEmpty() || prompted[0] == true) {
					GameMap.getHuman().executeAll();
					if (players != null) {
						for (Player ai : players) {
							if (ai instanceof AIPlayer) {
								ai.executeAll();
							}
						}
						prompted[0] = false;
						holder.turnEndUpdate();
					} else {
						//generate an Are You Sure? prompt and set prompted[0] = true
					}
				}
				endTurn();
			}
		});
	}
}
