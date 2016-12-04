package ATSSG;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Menu extends UIContainer<MenuElement> {
	
	//Variables

	//Methods
	public Menu(Collection<MenuElement> menuButtons, int width, int height, final JPanel paneSwitcher, final GameMap gm,
			final Gooey holder) throws IOException {
		super(menuButtons, width, height);
		
		view = new JPanel();
		
		final JPanel menuPanes = new JPanel();
		final CardLayout menuCards = new CardLayout();
		menuPanes.setLayout(menuCards);
		//Card 1: Menu Buttons
		//Card 2: New Game Interface
		//Card 3: Saving Interface
		//Card 4: Loading Interface
		
		ImageIcon settingsImage = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoSettings.png").toString())).getScaledInstance(width / 6, height / 9, Image.SCALE_SMOOTH));
		final MenuElement settings = new MenuElement(settingsImage, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//dummy button 4
			}
		});
		
		ImageIcon saveImage = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoSave.png").toString())).getScaledInstance(width / 6, height / 9, Image.SCALE_SMOOTH));
		final MenuElement save = new MenuElement(saveImage, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					//gm.update(Paths.get("src/ATSSG/Maps/5v5.map").toString());
					//holder.updateGameMap(gm);
					FileOutputStream out = new FileOutputStream("src/ATSSG/save.sav");
					out.write(gm.Save());
					out.close();
				}catch(Exception x){
					System.out.println(x.toString());
				}
			}
		});
		save.setEnabled(false);
		
		ImageIcon resumeImage = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoResume.png").toString())).getScaledInstance(width / 6, height / 9, Image.SCALE_SMOOTH));
		final MenuElement resume = new MenuElement(resumeImage, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) paneSwitcher.getLayout();
				cl.next(paneSwitcher);
			}
		});
		resume.setEnabled(false);
		
		ImageIcon backImage = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoBack.png").toString())).getScaledInstance(width / 3, height / 15, Image.SCALE_SMOOTH));
		final MenuElement backButton = new MenuElement(backImage, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuCards.first(menuPanes);
			}
		});
		
		ImageIcon newImage = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoNew.png").toString())).getScaledInstance(width / 6, height / 9, Image.SCALE_SMOOTH));
		content.add(new MenuElement(newImage, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuCards.next(menuPanes);
			}
		}));
		content.add(settings);
		ImageIcon loadImage = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoLoad.png").toString())).getScaledInstance(width / 6, height / 9, Image.SCALE_SMOOTH));
		content.add(new MenuElement(loadImage, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					File file = new File("src/ATSSG/save.sav");
					FileInputStream in = new FileInputStream(file);
					byte[] contents = new byte[(int)file.length()];
					in.read(contents);
					in.close();
					
					gm.update(GameMap.Load(contents));
					holder.updateGameMap(gm);
					save.setEnabled(true);
					resume.setEnabled(true);
					backButton.doClick();
					resume.doClick();
				}catch(FileNotFoundException x){
					//Silently drop.
				}
				catch(Exception x){
					System.out.println(x.toString());
				}
			}
		}));
		content.add(save);
		ImageIcon exitImage = new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoExit.png").toString())).getScaledInstance(width / 6, height / 9, Image.SCALE_SMOOTH));
		content.add(new MenuElement(exitImage, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFrame containerPrime = (JFrame) (paneSwitcher.getTopLevelAncestor());
				containerPrime.dispatchEvent(new WindowEvent(containerPrime, WindowEvent.WINDOW_CLOSING));
			}
		}));
		content.add(resume);
		
		JPanel buttonView = new JPanel();
		buttonView.setLayout(new GridLayout(3, 2));
		for (MenuElement me : content) {
			buttonView.add(me);
		}
		buttonView.setVisible(true);
		
		JPanel newGame = new JPanel();
		newGame.setLayout(new GridLayout(5, 1));
		newGame.add(new MenuElement("New Game Scenario 1", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.update(Paths.get("src/ATSSG/Maps/5v5.map").toString());
				holder.updateGameMap(gm);
				save.setEnabled(true);
				resume.setEnabled(true);
				backButton.doClick();
				resume.doClick();
				holder.getPrompts().createMessagePrompt("New Game - Basic", "GL HF!", null);
			}
		}));
		newGame.add(new MenuElement("New Game Scenario 2", new ActionListener() {//They will update GameMap with the appropriate file (somehow - I need that method)
			public void actionPerformed(ActionEvent e) {
				gm.update(Paths.get("src/ATSSG/Maps/Roughpatch.map").toString());
				holder.updateGameMap(gm);
				save.setEnabled(true);
				resume.setEnabled(true);
				backButton.doClick();
				resume.doClick();
				holder.getPrompts().createMessagePrompt("New Game - Terrained", "GL HF!", null);
			}
		}));
		newGame.add(new MenuElement("New Game Scenario 3", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.update(Paths.get("src/ATSSG/Maps/Large.map").toString());
				holder.updateGameMap(gm);
				save.setEnabled(true);
				resume.setEnabled(true);
				backButton.doClick();
				resume.doClick();
				holder.getPrompts().createMessagePrompt("New Game - Large", "GL HF!", null);
			}
		}));
		newGame.add(new MenuElement("New Game Random Scenario", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Random Scenario?
			}
		}));
		newGame.add(backButton);
		newGame.setVisible(true);
		
		Dimension bkgrndSize = new Dimension(width / 3, height / 3);
		
		buttonView.setPreferredSize(bkgrndSize);
		newGame.setPreferredSize(bkgrndSize);
		
		menuPanes.setPreferredSize(bkgrndSize);
		menuPanes.add(buttonView);
		menuPanes.add(newGame);
		menuPanes.setVisible(true);
		
		String bg1 = Paths.get("src/ATSSG/Art/DemoMenuBackground1.png").toString();
		String bg2 = Paths.get("src/ATSSG/Art/DemoMenuBackground2.png").toString();
		JLabel background1 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg1)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background1.setPreferredSize(bkgrndSize);
		background1.setVisible(true);
		
		JLabel background2 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg1)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background2.setPreferredSize(bkgrndSize);
		background2.setVisible(true);
		
		JLabel background3 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg1)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background3.setPreferredSize(bkgrndSize);
		background3.setVisible(true);
		
		JLabel background4 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg2)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background4.setPreferredSize(bkgrndSize);
		background4.setVisible(true);
		
		JLabel background5 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg1)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background5.setPreferredSize(bkgrndSize);
		background5.setVisible(true);
		
		JLabel background6 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg1)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background6.setPreferredSize(bkgrndSize);
		background6.setVisible(true);
		
		JLabel background7 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg1)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background7.setPreferredSize(bkgrndSize);
		background7.setVisible(true);
		
		JLabel background8 = new JLabel(new ImageIcon(
				ImageIO.read(new File(bg1)).getScaledInstance((int)(width / 3.0), (int)(height / 3.0), Image.SCALE_SMOOTH)));
		background8.setPreferredSize(bkgrndSize);
		background8.setVisible(true);
		
		GridBagLayout gbl = new GridBagLayout();
		
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
