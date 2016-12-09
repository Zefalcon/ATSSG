package ATSSG.Script;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Evelyn Moss on 12/8/2016.
 */
@SuppressWarnings("serial")
public class LoopPopup extends Dialog implements ActionListener {

	ScriptInterface inter;

	Label condition;
	Button addButton;

	TextField cond;

	public LoopPopup(ScriptInterface owner){
		super(owner);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				we.getWindow().setVisible(false);
			}});
		inter = owner;

		setLayout(new FlowLayout());
		condition = new Label("Condition");

		addButton = new Button("Add Statement");
		addButton.addActionListener(this);

		cond = new TextField("Type condition here");

		add(condition);
		add(cond);
		add(addButton);

		setTitle("Set Variable");
		setSize(250, 100);
	}

	public void actionPerformed(ActionEvent e){
		String cond = condition.getText();
		inter.addLoopAtPointer(cond);
		this.setVisible(false);
	}
}
