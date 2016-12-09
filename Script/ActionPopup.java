package ATSSG.Script;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import ATSSG.Script.Framework.*;
import ATSSG.Enums.CommandType;

/**
 * Created by Evelyn Moss on 12/4/2016.
 */
@SuppressWarnings("serial")
public class ActionPopup extends Dialog implements ActionListener, ItemListener{

	Script environment;
	ScriptInterface inter;

	//Variables for any version of ActionPopup
	Label label;
	Choice options;
	Button addButton;

	//For specifying type
	Label typeLabel;

	//For Move
	TextField x;
	TextField y;

	//For Attack
	TextField target;

	public ActionPopup(ScriptInterface owner) {
		super(owner);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				we.getWindow().setVisible(false);
			}});
		inter = owner;
		//Setup specifics to be used later
		typeLabel = new Label("Target");
		x = new TextField("Type x coordinate");
		y = new TextField("Type y coordinate");
		target = new TextField("Type in target's id");

		setLayout(new FlowLayout());
		label = new Label("ActionType");

		options = new Choice();
		options.add("Idle");
		options.add("Attack");
		options.add("Move");
		options.select(0); //Make sure we begin on Idle because it doesn't have any extra components.
		options.addItemListener(this);

		addButton = new Button("Add Action");
		addButton.addActionListener(this);

		add(label);
		add(options);
		add(addButton);

		//Add and set invisible
		typeLabel.setVisible(false);
		add(typeLabel);
		x.setVisible(false);
		add(x);
		y.setVisible(false);
		add(y);
		target.setVisible(false);
		add(target);

		setTitle("Add Action");
		setSize(250, 100);
	}

	public void actionPerformed(ActionEvent e){
		environment = inter.environment;
		String choice = options.getSelectedItem();
		Statement toAdd;
		switch (choice){
			case "Attack":{
				toAdd = new ActionStatement(CommandType.ATTACK, Arrays.asList(target.getText()));
				break;
			}
			case "Idle":{
				//Add new idle action
				toAdd = new ActionStatement(CommandType.IDLE, new ArrayList<String>());
				break;
			}
			case "Move":{
				toAdd = new ActionStatement(CommandType.MOVE, Arrays.asList(x.getText(), y.getText()));
				break;
			}
			default:{
				//Should NOT get here.  Default to Idle
				//Add new idle action
				toAdd = new ActionStatement(CommandType.IDLE, new ArrayList<String>());
				break;
			}
		}
		//Add statement to block
		inter.addAtPointer(toAdd);
		this.setVisible(false);
	}

	public void itemStateChanged(ItemEvent e){
		String choice = options.getSelectedItem();
		switch (choice){
			case "Attack":{
				//Set target visible
				typeLabel.setText("Target");
				typeLabel.setVisible(true);
				target.setVisible(true);
				//Set everything else invisible
				x.setVisible(false);
				y.setVisible(false);
				break;
			}
			case "Idle":{
				//Set everything invisible
				typeLabel.setVisible(false);
				target.setVisible(false);
				x.setVisible(false);
				y.setVisible(false);
				break;
			}
			case "Move":{
				//Set x and y visible
				typeLabel.setText("Destination");
				typeLabel.setVisible(true);
				x.setVisible(true);
				y.setVisible(true);
				//Set target invisible
				target.setVisible(false);
				break;
			}
			default:{
				//Should NOT get here.  Default to idle
				//Set everything invisible
				typeLabel.setVisible(false);
				target.setVisible(false);
				x.setVisible(false);
				y.setVisible(false);
				break;
			}
		}
		this.pack();
	}
}
