package ATSSG;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainScroller extends UIContainer<Object> {
	
	//Variables
	
	protected MainMap mainMap;
	protected final int[] cameraConstants; //camTop, cameraConstants[1], cameraConstants[2], cameraConstants[3], cameraConstants[4], cameraConstants[5]
	protected final JButton scrollUp;
	protected final JButton scrollLeft;
	protected final JButton scrollRight;
	protected final JButton scrollDown;
	
	//Constructors

	public MainScroller(int width, int height, MainMap mainMap) {
		super(null, width, height);
		cameraConstants = new int[6];
		scrollUp = new JButton("^");
		scrollLeft = new JButton("<");
		scrollRight = new JButton(">");
		scrollDown = new JButton("v");
		
		
		ActionListener alUp = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[0]--; cameraConstants[3]--;
				mainMap.updateView(cameraConstants[1], cameraConstants[0]);
				if (cameraConstants[0] == 0) {scrollUp.setEnabled(false);}
				scrollDown.setEnabled(true);
			}
		};
		scrollUp.addActionListener(alUp);
		
		ActionListener alLeft = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[1]--; cameraConstants[2]--;
				mainMap.updateView(cameraConstants[1], cameraConstants[0]);
				if (cameraConstants[1] == 0) {scrollLeft.setEnabled(false);}
				scrollRight.setEnabled(true);
			}
		};
		scrollLeft.addActionListener(alLeft);
		
		ActionListener alRight = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[2]++; cameraConstants[1]++;
				mainMap.updateView(cameraConstants[1], cameraConstants[0]);
				if (cameraConstants[2] == cameraConstants[4] - 1) {scrollRight.setEnabled(false);}
				scrollLeft.setEnabled(true);
			}
		};
		scrollRight.addActionListener(alRight);
		
		ActionListener alDown = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[3]++; cameraConstants[0]++;
				mainMap.updateView(cameraConstants[1], cameraConstants[0]);
				if (cameraConstants[3] == cameraConstants[5] - 1) {scrollDown.setEnabled(false);}
				scrollUp.setEnabled(true);
			}
		};
		scrollDown.addActionListener(alDown);
		
		scrollUp.setPreferredSize(new Dimension(width, 50));
		scrollLeft.setPreferredSize(new Dimension(50, height - 100));
		scrollRight.setPreferredSize(new Dimension(50, height - 100));
		scrollDown.setPreferredSize(new Dimension(width, 50));
		
		view = new JPanel();
		view.setLayout(new BorderLayout());
		view.add(scrollUp, BorderLayout.NORTH);
		view.add(scrollLeft, BorderLayout.WEST);
		view.add(scrollRight, BorderLayout.EAST);
		view.add(scrollDown, BorderLayout.SOUTH);
		view.add(mainMap.getView(), BorderLayout.CENTER);
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	public void updateBounds(MainMap ref) {
		mainMap = ref;
		cameraConstants[0] = ref.getCamTop();
		cameraConstants[1] = ref.getCamLeft();
		cameraConstants[2] = ref.getCamRight();
		cameraConstants[3] = ref.getCamBot();
		cameraConstants[4] = ref.getMapW();
		cameraConstants[5] = ref.getMapH();
		scrollUp.setEnabled(cameraConstants[0] > 0);
		scrollLeft.setEnabled(cameraConstants[1] > 0);
		scrollRight.setEnabled(cameraConstants[2] < cameraConstants[4] - 1);
		scrollDown.setEnabled(cameraConstants[3] < cameraConstants[5] - 1);
	}
}
