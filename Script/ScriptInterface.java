package ATSSG.Script;
import ATSSG.Entities.Entity;
import ATSSG.Script.Framework.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScriptInterface extends JFrame implements ActionListener, ListSelectionListener{

	JList<String/*Statement*/> script;
	Button addButton;
	//Button expandButton;
	Choice options;
	DefaultListModel<String> model;
	ActionPopup addAction;
	SetVarPopup setVar;
	DeclareVarPopup declareVar;
	AccessDataPopup accessData;
	Entity actor;
	Script environment;
	//TODO: Need subclass that holds Statement?  Or just do a list of statements?

	public ScriptInterface(Entity thisEntity, Script env){
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				setVisible(false);
			}});

		addButton = new Button("Add new statement");
		addButton.addActionListener(this);
		//expandButton = new Button("Expand block");
		//expandButton.addActionListener(this);

		addAction = new ActionPopup(this);
		setVar = new SetVarPopup(this);
		declareVar = new DeclareVarPopup(this);
		accessData = new AccessDataPopup(this);

		options = new Choice();
		options.add("Action");
		//options.add("If Statement");
		//options.add("Loop");
		options.add("Set Variable");
		options.add("Declare Variable");
		//options.add("Access Data");
		//options.add("Block");

		actor = thisEntity;
		environment = env;

		setLayout(new FlowLayout());

		model = new DefaultListModel<>();
		model.addElement("No statements");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		model.addElement("");
		script = new JList<String>(model);
		script.setFixedCellWidth(200);
		script.setFixedCellHeight(15);
		add(script);
		script.addListSelectionListener(this);

		//add(expandButton);
		add(addButton);
		add(options);

		setTitle(actor.toString() + "Script");
		setSize(250, 500);
		setVisible(true);
	}

	public static void main(String[] args){
		ScriptInterface si = new ScriptInterface(null, null);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(addButton)){
			//Add current statement to block
			String choice = options.getSelectedItem();
			switch (choice){
				case "Action":{
					//Open Add Action window
					addAction.setVisible(true);
					break;
				}
				/*case "IfStatement":{
					//Open Add If Statement window
					//toAdd = window.getStatement(); or something
					break;
				}*/
				/*case "Loop":{
					//Open Add Loop window
					//toAdd = window.getStatement(); or something
					break;
				}*/
				case "Set Variable":{
					//Open Set Variable window
					setVar.setVisible(true);
					break;
				}
				case "Declare Variable":{
					//Open Declare Variable window
					declareVar.setVisible(true);
					break;
				}
				/*case "Access Data":{
					//Open Access Data window
					//accessData.setVisible(true);  No implementation for demo
					break;
				}*/
				/*case "Block":{
					//Open Add Block window
					//toAdd = window.getStatement(); or something
					break;
				}*/
				default:{
					//Code should NOT get here, but if it does, it means Choice doesn't automatically choose the top of the list.
					//Do it manually.
					//Open Add Action window
					addAction.setVisible(true);
					break;
				}
			}
		}
		/*else if(e.getSource().equals(expandButton)){
			//Expand currently chosen block
		}*/
	}

	public void addAtPointer(Statement toAdd){
		String selected = script.getSelectedValue();
		if(model.getElementAt(0).equals("No statements")) { //No statements yet.  Clear, then add to end.
			model.removeAllElements();
			model.addElement(toAdd.toString());
			//model.addElement("No selection!"); //For testing
			environment.getLines().addAtEnd(toAdd);
		}
		else { //Add after selected value
			if (selected == null) { //Nothing selected, add to end.
				model.addElement(toAdd.toString());
				//model.addElement("Add at end"); //For testing
				environment.getLines().addAtEnd(toAdd);
			}
			else { //Add after selected value
				model.add(script.getSelectedIndex() + 1, toAdd.toString());
				//model.add(script.getSelectedIndex() + 1, "After!"); //For testing
				environment.getLines().addStatement(toAdd, script.getSelectedIndex()+1); //TODO: Hack, pls fix
				//environment.getLines().addAfter(toAdd, selected); //This is approximately the line that needs to happen
			}
		}
	}

	public void valueChanged(ListSelectionEvent e){
		//Specifically for drag-and-drop.  Probably not needed beforehand.
	}

}