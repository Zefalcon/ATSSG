package ATSSG.Script;

import java.awt.*;
import java.awt.event.*;

import ATSSG.Script.Framework.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Evelyn Moss on 12/4/2016.
 */
@SuppressWarnings("serial")
public class AccessDataPopup extends Dialog implements ActionListener, ItemListener {

	ScriptInterface inter;

	Label type;
	Label variable;

	Choice options;
	TextField var;
	DataAccessStatement.AccessType dataType;

	//Something for arguments
	TextField uid;
	TextField x;
	TextField y;

	Button addButton;

	public AccessDataPopup(ScriptInterface owner){
		super(owner);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				we.getWindow().setVisible(false);
			}});
		inter = owner;
		dataType = DataAccessStatement.AccessType.My_ID;

		setLayout(new FlowLayout());
		variable = new Label("Variable Name");
		type = new Label("Data to Access");

		addButton = new Button("Add Statement");
		addButton.addActionListener(this);

		var = new TextField("[Name]");

		uid = new TextField("[Unit ID]");
		x = new TextField("[X coordinate]");
		y = new TextField("[Y coordinate]");

		options = new Choice();
		options.add("Unit ID");
		options.add("Current HP");
		options.add("Maximum HP");
		options.add("Maximum Moves");
		options.add("Attack Range");
		options.add("Damage");
		options.add("Is Alive?");
		options.add("Is Enemy?");
		options.add("Maximum Valid ID");
		options.add("X Location");
		options.add("Y Location");
		options.add("Is Cell Passable?");
		options.add("Cell Cost");
		options.select(0);

		add(type);
		add(options);
		add(variable);
		add(var);

		//Add invisible text fields
		uid.setVisible(false);
		add(uid);
		x.setVisible(false);
		add(x);
		y.setVisible(false);
		add(y);

		add(addButton);

		setTitle("Access Data");
		setSize(250, 100);
	}

	public void actionPerformed(ActionEvent e){
		List<String> args = new ArrayList<>();
		if(uid.isVisible()){
			args.add(uid.getText());
		}
		if(x.isVisible()){
			args.add(x.getText());
		}
		if(y.isVisible()){
			args.add(y.getText());
		}
		Statement toAdd = new DataAccessStatement(dataType, var.getText(), args);
		inter.addAtPointer(toAdd);
		this.setVisible(false);
	}

	public void itemStateChanged(ItemEvent e){
		String choice = options.getSelectedItem();
		switch (choice){
			case "Current HP":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Current_HP;
				break;
			}
			case "Maximum HP":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Maximum_HP;
				break;
			}
			case "Maximum Moves":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Maximum_Moves;
				break;
			}
			case "Attack Range":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Range;
				break;
			}
			case "Damage":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Damage;
				break;
			}
			case "Unit ID":{
				//Set everything invisible
				uid.setVisible(false);
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.My_ID;
				break;
			}
			case "Is Alive?":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Is_Alive;
				break;
			}
			case "Is Enemy?":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Is_Enemy;
				break;
			}
			case "Maximum Valid ID":{
				//Set everything invisible
				uid.setVisible(false);
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Maximum_valid_id;
				break;
			}
			case "X Location":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.X_Loc;
				break;
			}
			case "Y Location":{
				//Set uid visible
				uid.setVisible(true);
				//Set x and y invisible
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.Y_Loc;
				break;
			}
			case "Is Cell Passable?":{
				//Set all visible
				uid.setVisible(true);
				x.setVisible(true);
				y.setVisible(true);
				dataType = DataAccessStatement.AccessType.IsCellPassable;
				break;
			}
			case "Cell Cost":{
				//Set all visible
				uid.setVisible(true);
				x.setVisible(true);
				y.setVisible(true);
				dataType = DataAccessStatement.AccessType.Cell_Cost;
				break;
			}
			default:{
				//Should NOT get here.  Default to nothing visible
				uid.setVisible(false);
				x.setVisible(false);
				y.setVisible(false);
				dataType = DataAccessStatement.AccessType.My_ID;
				break;
			}
		}
		this.pack();
	}
}
