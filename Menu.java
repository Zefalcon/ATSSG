package ATSSG;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ATSSG.Player.Player;

public class Menu extends UIContainer<MenuElement> {
	
	//Variables

	//Methods
	public Menu(Collection<MenuElement> menuButtons, int width, int height, Player owner, final JPanel paneSwitcher, final GameMap gm,
			final Gooey holder) {
		super(menuButtons, width, height, owner);
		
		final JPanel menuPanes = new JPanel();
		final CardLayout menuCards = new CardLayout();
		menuPanes.setLayout(menuCards);
		//Card 1: Menu Buttons
		//Card 2: New Game Interface
		//Card 3: Saving Interface
		//Card 4: Loading Interface
		
		content.add(new MenuElement(new ImageIcon(Paths.get("src/ATSSG/Art/DemoNew.png").toString()), owner, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuCards.next(menuPanes);
			}
		}));
		
		MenuElement stats = new MenuElement(new ImageIcon(Paths.get("src/ATSSG/Art/DemoStats.png").toString()), owner, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//dummy button 4
			}
		});
		stats.getView().setEnabled(false);
		content.add(stats);
		
		content.add(new MenuElement(new ImageIcon(Paths.get("src/ATSSG/Art/DemoLoad.png").toString()), owner, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//dummy button 2
			}
		}));
		
		MenuElement save = new MenuElement(new ImageIcon(Paths.get("src/ATSSG/Art/DemoSave.png").toString()), owner, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//dummy button 5
			}
		});
		save.getView().setEnabled(false);
		content.add(save);
		
		content.add(new MenuElement(new ImageIcon(Paths.get("src/ATSSG/Art/DemoExit.png").toString()), owner, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFrame containerPrime = (JFrame) (paneSwitcher.getTopLevelAncestor());
				containerPrime.dispatchEvent(new WindowEvent(containerPrime, WindowEvent.WINDOW_CLOSING));
			}
		}));
		
		MenuElement resume = new MenuElement(new ImageIcon(Paths.get("src/ATSSG/Art/DemoResume.png").toString()), owner, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) paneSwitcher.getLayout();
				cl.next(paneSwitcher);
			}
		});
		resume.getView().setEnabled(false);
		content.add(resume);
		
		JPanel buttonView = new JPanel();
		buttonView.setLayout(new GridLayout(3, 2));
		for (MenuElement me : content) {
			buttonView.add(me.getView());
		}
		buttonView.setVisible(true);
		
		ImageIcon back = new ImageIcon(Paths.get("src/ATSSG/Art/DemoBack.png").toString());
		MenuElement backButton = new MenuElement(back, owner, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuCards.first(menuPanes);
			}
		});
		
		JPanel newGame = new JPanel();
		newGame.setLayout(new GridLayout(5, 1));
		newGame.add(new MenuElement("New Game Scenario 1", owner, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.update(Paths.get("src/ATSSG/Maps/5v5.map").toString());
				holder.updateGameMap(gm);
				stats.getView().setEnabled(true);
				save.getView().setEnabled(true);
				resume.getView().setEnabled(true);
				backButton.getView().doClick();
				resume.getView().doClick();
			}
		}).getView());
		newGame.add(new MenuElement("New Game Scenario 2", owner, new ActionListener() {//They will update GameMap with the appropriate file (somehow - I need that method)
			public void actionPerformed(ActionEvent e) {
				gm.update(Paths.get("src/ATSSG/Maps/Roughpatch.map").toString());
				holder.updateGameMap(gm);
				stats.getView().setEnabled(true);
				save.getView().setEnabled(true);
				resume.getView().setEnabled(true);
				backButton.getView().doClick();
				resume.getView().doClick();
			}
		}).getView());
		newGame.add(new MenuElement("New Game Scenario 3", owner, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Scenario 3
			}
		}).getView());
		newGame.add(new MenuElement("New Game Random Scenario", owner, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Random Scenario?
			}
		}).getView());
		newGame.add(backButton.getView());
		newGame.setVisible(true);
		
		Dimension bkgrndSize = new Dimension(width / 3, height / 3);
		
		buttonView.setPreferredSize(bkgrndSize);
		newGame.setPreferredSize(bkgrndSize);
		
		menuPanes.setPreferredSize(bkgrndSize);
		menuPanes.add(buttonView);
		menuPanes.add(newGame);
		menuPanes.setVisible(true);
		
		JLabel background1 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString()));
		background1.setPreferredSize(bkgrndSize);
		background1.setVisible(true);
		
		JLabel background2 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString()));
		background2.setPreferredSize(bkgrndSize);
		background2.setVisible(true);
		
		JLabel background3 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString()));
		background3.setPreferredSize(bkgrndSize);
		background3.setVisible(true);
		
		JLabel background4 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground2.png").toString()));
		background4.setPreferredSize(bkgrndSize);
		background4.setVisible(true);
		
		JLabel background5 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString()));
		background5.setPreferredSize(bkgrndSize);
		background5.setVisible(true);
		
		JLabel background6 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString()));
		background6.setPreferredSize(bkgrndSize);
		background6.setVisible(true);
		
		JLabel background7 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString()));
		background7.setPreferredSize(bkgrndSize);
		background7.setVisible(true);
		
		JLabel background8 = new JLabel(new ImageIcon(Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString()));
		background8.setPreferredSize(bkgrndSize);
		background8.setVisible(true);
		
		GridBagLayout gbl = new GridBagLayout();
		
		view = new JPanel();
		view.setLayout(gbl);
		view.setPreferredSize(getSize());
		view.add(background1);
		gbl.setConstraints(background1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(background2);
		gbl.setConstraints(background2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(background3);
		gbl.setConstraints(background3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(background4);
		gbl.setConstraints(background4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(background5);
		gbl.setConstraints(background5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(menuPanes);
		gbl.setConstraints(menuPanes, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(background6);
		gbl.setConstraints(background6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(background7);
		gbl.setConstraints(background7, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		view.add(background8);
		gbl.setConstraints(background8, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}
}
