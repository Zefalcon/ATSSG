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
	protected GameMap gm;
	protected UnitQueue uq;
	protected Player owner;
	protected Boolean prompted = false;
	
	//Constructors
	
	public EndTurnButton(int width, int height, final Player owner, final Gooey holder, final GameMap gm,
			final UnitQueue uq) {
		super(new ImageIcon(Paths.get("src/ATSSG/Art/DemoEndTurn.png").toString()));
		this.holder = holder;
		this.gm = gm;
		this.uq = uq;
		this.owner = owner;
		this.setSize(new Dimension(width, height));
	}
	
	//Methods
	
	public void updateComputers() {
		final Collection<AIPlayer> computers = gm.getComputers();
		for (ActionListener actlis : this.getActionListeners()) {
			this.removeActionListener(actlis);
		}
		this.addActionListener(new ActionListener() {
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
