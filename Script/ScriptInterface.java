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
import java.util.List;

public class ScriptInterface extends JFrame implements ActionListener, ListSelectionListener{

	JList<String> script;
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

	public ScriptInterface(Entity thisEntity){
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				setVisible(false);
			}});

		addButton = new Button("Add new statement");
		addButton.addActionListener(this);
		//expandButton = new Button("Expand block");
		//expandButton.addActionListener(this);

		addAction = new ActionPopup(this);
		addAction.setLocation(250,0);
		setVar = new SetVarPopup(this);
		setVar.setLocation(250,0);
		declareVar = new DeclareVarPopup(this);
		declareVar.setLocation(250,0);
		accessData = new AccessDataPopup(this);
		accessData.setLocation(250,0);

		options = new Choice();
		options.add("Action");
		//options.add("If Statement");
		//options.add("Loop");
		options.add("Set Variable");
		options.add("Declare Variable");
		options.add("Access Data");

		actor = thisEntity;
		if(actor != null) {
			environment = thisEntity.getCurrentScript();
		}

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

		setTitle("Script");
		setSize(250, 500);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(false);
	}

	/*public static void main(String[] args){
		ScriptInterface si = new ScriptInterface(null, null);
	}*/

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
				case "Access Data":{
					//Open Access Data window
					accessData.setVisible(true);
					break;
				}
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
			environment.getLines().addAtEnd(toAdd);
			System.out.println(toAdd.toString() + " added");
		}
		else { //Add after selected value
			if (selected == null) { //Nothing selected, add to end.
				model.addElement(toAdd.toString());
				environment.getLines().addAtEnd(toAdd);
				System.out.println(toAdd.toString() + " added");
			}
			else { //Add after selected value
				model.add(script.getSelectedIndex() + 1, toAdd.toString());
				environment.getLines().addStatement(toAdd, script.getSelectedIndex()+1); //TODO: Hack, pls fix
				//environment.getLines().addAfter(toAdd, selected); //This is approximately the line that needs to happen
				System.out.println(toAdd.toString() + " added");
			}
		}
	}

	public void update(){
		update(actor);
	}

	public void update(Entity newEntity){
		actor = newEntity;
		if(actor != null) {
			environment = newEntity.getCurrentScript();
			setTitle(actor.toString() + "Script");
		}

		if(environment == null /*|| environment.getLines().statementDone()*/){
			model.removeAllElements();
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
			environment = new Script(actor);
		}
		else{ //Populate with lines from script
			List<Statement> lines = environment.getLines().getLines();
			for(int i=0;i<lines.size();i++){
				model.addElement(lines.get(i).toString());
			}
		}
	}

	public void valueChanged(ListSelectionEvent e){
		//Specifically for drag-and-drop.  Probably not needed beforehand.
	}

}