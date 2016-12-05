package ATSSG.Script;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ATSSG.Script.Framework.*;

/**
 * Created by Evelyn Moss on 12/4/2016.
 */
public class AccessDataPopup extends Dialog implements ActionListener {

	ScriptInterface inter;

	Label type;
	Label variable;

	Choice options;
	TextField var;
	//Something for arguments

	Button addButton;

	public AccessDataPopup(ScriptInterface owner){
		super(owner);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				we.getWindow().setVisible(false);
			}});
		inter = owner;

		setLayout(new FlowLayout());
		variable = new Label("Variable Name");
		type = new Label("Data to Access");

		addButton = new Button("Add Statement");
		addButton.addActionListener(this);

		var = new TextField("[Name]");

		options = new Choice();
		options.add("Current HP");
		options.add("Maximum HP");
		options.add("Maximum Moves");
		options.add("Attack Range");
		options.add("Damage");
		options.add("Unit ID");
		options.add("Is Alive?");
		options.add("Is Enemy?");
		options.add("Maximum Valid ID");
		options.add("X Location");
		options.add("Y Location");
		options.add("Is Cell Passable?");
		options.add("Cell Cost");

		add(type);
		add(options);
		add(variable);
		add(var);
		//add something
		add(addButton);

		setTitle("Access Data");
		setSize(250, 80);
	}

	public void actionPerformed(ActionEvent e){
		//TODO: Get to work properly
		//Statement toAdd = new SetVariableStatement(var.getText(), val.getText());
		//inter.addAtPointer(toAdd);
		this.setVisible(false);
	}
}

