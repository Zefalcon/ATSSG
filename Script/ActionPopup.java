package ATSSG.Script;

import java.awt.*;
import java.awt.event.*;

import ATSSG.Script.Framework.*;
import ATSSG.Entities.*;
import ATSSG.Actions.*;
import ATSSG.GameMap;
import ATSSG.Cell;

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
				//resetWindow();
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
				//Ask for target of attack
				int id;
				try {
					id = Expression.getDoubleValue(target.getText(), environment).intValue();
				}
				catch(Exception ex){
					//Throw up some exception or other.
					System.out.println("Number not right");
					return;
				}
				//Get entity from id
				Entity enemy = DataAccessStatement.getEntity(id, environment);
				//Add new attack action
				if(enemy != null){
					toAdd = new ActionStatement(new AttackAction(1, (Unit)environment.getOwner(), enemy));
				}
				else{
					//Throw up some exception or other.
					System.out.println("Enemy does not exist");
					return;
				}
				break;
			}
			case "Idle":{
				//Add new idle action
				toAdd = new ActionStatement(new IdleAction());
				break;
			}
			case "Move":{
				//Ask for destination in x and y
				int xVal;
				int yVal;
				try {
					xVal = Expression.getDoubleValue(x.getText(), environment).intValue();
					yVal = Expression.getDoubleValue(y.getText(), environment).intValue();
				}
				catch(Exception ex){
					//Throw up some exception or other.
					System.out.println("Not a number");
					return;
				}
				//Get Cell from id
				GameMap map = environment.getOwner().getOwner().getContaining_map();
				Cell dest = map.getCell(xVal, yVal);
				//Add new move action
				if(dest != null){
					toAdd = new ActionStatement(new MoveAction(1, (Unit)environment.getOwner(), dest));
				}
				else{
					//Throw up some exception or other.
					System.out.println("Cell does not exist");
					return;
				}
				break;
			}
			default:{
				//Should NOT get here.  Default to Idle
				//Add new idle action
				toAdd = new ActionStatement(new IdleAction());
				break;
			}
		}
		//Add statement to block
		inter.addAtPointer(toAdd);
		//resetWindow();
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

	public void resetWindow(){
		typeLabel = new Label("Target");
		x = new TextField("Type x coordinate");
		y = new TextField("Type y coordinate");
		target = new TextField("Type in target's id");
		typeLabel.setVisible(false);
		target.setVisible(false);
		x.setVisible(false);
		y.setVisible(false);
		options.select(0);
		this.pack();
	}

}
