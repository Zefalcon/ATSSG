package ATSSG.Script;
import ATSSG.Entities.Entity;
import ATSSG.Script.Framework.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ScriptInterface extends JFrame implements ActionListener{

	JList<String> script;
	Button addButton;
	Button updateButton;
	List<Statement> statementList;
	Choice options;
	DefaultListModel<String> model;
	ActionPopup addAction;
	SetVarPopup setVar;
	DeclareVarPopup declareVar;
	AccessDataPopup accessData;
	IfPopup ifState;
	LoopPopup loop;
	Entity actor;
	Script environment;

	public ScriptInterface(Entity thisEntity){
		this.addWindowListener(
			new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent we){
					setVisible(false);
				}
			}
		);

		addButton = new Button("Add new statement");
		addButton.addActionListener(this);
		updateButton = new Button("Update script");
		updateButton.addActionListener(this);

		addAction = new ActionPopup(this);
		addAction.setLocation(250,0);
		setVar = new SetVarPopup(this);
		setVar.setLocation(250,0);
		declareVar = new DeclareVarPopup(this);
		declareVar.setLocation(250,0);
		accessData = new AccessDataPopup(this);
		accessData.setLocation(250,0);
		ifState = new IfPopup(this);
		ifState.setLocation(250,0);
		loop = new LoopPopup(this);
		loop.setLocation(250, 0);

		options = new Choice();
		options.add("Action");
		options.add("If Statement");
		options.add("Loop");
		options.add("Set Variable");
		options.add("Declare Variable");
		options.add("Access Data");
		
		statementList = new ArrayList<Statement>();

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

		add(addButton);
		add(options);
		add(updateButton);

		setTitle("Script");
		setSize(250, 500);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e){
		System.out.println("Before aperformed " + actor.getCurrentScript().getLines().getLines());
		if(e.getSource().equals(addButton)){
			//Add current statement to block
			String choice = options.getSelectedItem();
			switch (choice){
				case "Action":{
					//Open Add Action window
					addAction.setVisible(true);
					break;
				}
				case "IfStatement":{
					//Open Add If Statement window
					ifState.setVisible(true);
					break;
				}
				case "Loop":{
					//Open Add Loop window
					loop.setVisible(true);
					break;
				}
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
		else if(e.getSource().equals(updateButton)){
			updateScript();
			setVisible(false);
		}
		System.out.println("after aperformed " + actor.getCurrentScript().getLines().getLines());
	}

	public void addAtPointer(Statement toAdd){
		String selected = script.getSelectedValue();
		if(model.getElementAt(0).equals("No statements")) { //No statements yet.  Clear, then add to end.
			model.removeAllElements();
			model.addElement(toAdd.toString());
			//environment.getLines().addAtEnd(toAdd); TODO
			statementList.add(toAdd);
		}
		else { //Add after selected value
			if (selected == null) { //Nothing selected, add to end.
				model.addElement(toAdd.toString());
				//environment.getLines().addAtEnd(toAdd); TODO
				statementList.add(toAdd);
			}
			else { //Add after selected value
				model.add(script.getSelectedIndex() + 1, toAdd.toString());
				//environment.getLines().addStatement(toAdd, script.getSelectedIndex()+1); //Hack, pls fix TODO
				//environment.getLines().addAfter(toAdd, selected); //This is approximately the line that needs to happen TODO
				statementList.add(script.getSelectedIndex()+1, toAdd);
			}
		}
	}

	public void addIfAtPointer(String condition){
		model.addElement("If (" + condition + ")");
		model.addElement("Else");
		model.addElement("End If");
	}

	public void addLoopAtPointer(String condition){
		model.addElement("Loop (" + condition + ")");
		model.addElement("End Loop");
	}

	public void updateScript(){
		//Updates script on entity
		System.out.println("before uds " + actor.getCurrentScript().getLines().getLines());
		Block blocky = internalBlock(null);
		//environment.setLines(blocky);//Flag does this actually do anything independent of setting the actor's?
		actor.getCurrentScript().setLines(blocky);
		System.out.println("after uds " + actor.getCurrentScript().getLines().getLines());
	}

	public Block internalBlock(String end){
		//Creates internal block, can be used recursively.
		Block block = new Block();
		while(!model.isEmpty()){
			String line = model.remove(0);
			String loopcheck = line.substring(0, 4);
			String ifcheck = loopcheck.substring(0, 2);
			//Check for further blocks
			if(loopcheck.equals("Loop")){
				//Loop, evaluate block, then add
				String condition = line.substring(6, line.length()-1);
				block.addAtEnd(new LoopStatement(internalBlock("End Loop"), condition));
			}
			else if(ifcheck.equals("If")){
				//If statement, evaluate if and else blocks, then add
				String condition = line.substring(4, line.length()-1);
				block.addAtEnd(new ControlStatement(internalBlock("Else"), internalBlock("End If"), condition));
			}
			else if(line.equals(end)){
				//Block done, return
				return block;
			}
			else{
				//Normal statement, add
				if(!statementList.isEmpty()){
					block.addAtEnd(statementList.remove(0));
				}
			}
		}
		return block;
	}

	public void update(){
		update(actor);
	}

	public void update(Entity newEntity){

		if(environment != null)System.out.println("Pre-update " + actor.getCurrentScript().getLines().getLines().size());
		actor = newEntity;
		if(actor != null) {
			environment = newEntity.getCurrentScript();
			setTitle(actor.toString() + "Script");
		}

		if(environment == null || environment.getLines().statementDone()){
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
			populateInterface(lines);
		}

		System.out.println("Post-update " + actor.getCurrentScript().getLines().getLines().size());
	}

	public void populateInterface(List<Statement> lines){
		//Populates interface with given statement lines recursively
		for(int i=0; i<lines.size();i++){
			if(lines.get(0) instanceof ControlStatement){
				//If statement, separate out if and else blocks
				model.addElement("If (" + ((ControlStatement) lines.get(0)).getCondition() + ")");
				Statement trueState = ((ControlStatement) lines.get(0)).getTrueBranch();
				if(trueState instanceof Block){
					populateInterface(((Block) trueState).getLines());
				}
				else{
					//Just a statement.  Shouldn't be possible, but code may change.
					statementList.add(trueState);
				}
				model.addElement("Else");
				Statement falseState = ((ControlStatement) lines.get(0)).getFalseBranch();
				if(falseState instanceof  Block){
					populateInterface(((Block) falseState).getLines());
				}
				else{
					statementList.add(falseState);
				}
				model.addElement("End If");
			}
			else if(lines.get(0) instanceof LoopStatement){
				//Loop statement, separate out block
				model.addElement("Loop (" + ((LoopStatement) lines.get(0)).getCondition() + ")");
				Statement body = ((LoopStatement) lines.get(0)).getOriginalbody();
				if(body instanceof Block){
					populateInterface(((Block) body).getLines());
				}
				else{
					statementList.add(body);
				}
				model.addElement("End Loop");
			}
			else{
				model.addElement(lines.get(i).toString());
				statementList.add(lines.get(i));
			}
		}
	}
}