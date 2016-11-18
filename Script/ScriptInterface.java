package ATSSG.Script;
import java.util.Collection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ATSSG.Actions.Action;
import ATSSG.Entities.Unit;
import javax.swing.event.*;

import ATSSG.Actions.*;
import ATSSG.Button;
import ATSSG.Overlay;
import ATSSG.Player.Player;

public class ScriptInterface extends Overlay implements ListSelectionListener{
	
	//Variables
	
	protected Collection<Button> scriptElements;
	protected Button execute;
	protected Collection<?> assemblyZone;

	protected JList<StatementDisplay> list;
	protected DefaultListModel<StatementDisplay> model;
	protected Script environ;

	//Constructors
	
	public ScriptInterface(Collection<Object> content, int width, int height, Player owner, Script environment) {
		super(content, width, height, owner);
		environ = environment;

		ScriptButton addActionButton = new ScriptButton(null, owner);
		StatementListener statementListener = new StatementListener();
		//addActionButton.setActionCommand("Add Action");  //Probably not needed?
		//addActionButton.setEnabled(true);
		scriptElements.add(addActionButton);

		model = new DefaultListModel<StatementDisplay>();
		model.addElement(new StatementDisplay(new ActionStatement(null), "No Statements"));

		list = new JList<StatementDisplay>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(5);
		JScrollPane scroll = new JScrollPane(list);

		//view = new JPanel();
		view.setPreferredSize(getSize());
		view.add(addActionButton.getGooey());
		view.setVisible(true);
		view.add(scroll, BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		//No need to implement, because we don't really care about changes to the list besides updating the screen.
	}

	//Methods

	class OptionListener implements ListSelectionListener{
		//Doesn't exist until option is selected.

		public Action actionType;

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()){
				if(tempList.getSelectedIndex() == -1){
					//No selection, do nothing.
				}
				else{
					//Selection, provide selected object
					actionType = tempList.getSelectedValue();
				}
			}
		}
	}

	JList<Action> tempList;

	class StatementListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StatementDisplay selected = (StatementDisplay)list.getSelectedValue();
			if(selected == null){
				//Add at end
				//TODO:Bring up list of possible options (Action, Loop, etc.)
				StatementType type = StatementType.ACTION; //TODO: Replace with chosen option.
				//TODO:Make less hacky
				tempList = new JList<Action>(((ScriptButton)e.getSource()).getOptions());
				tempList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tempList.setSelectedIndex(0);
				OptionListener listener = new OptionListener();
				tempList.addListSelectionListener(listener);
				tempList.setVisibleRowCount(5);
				JScrollPane pane = new JScrollPane(tempList);
				//TODO: Wait somehow for user input
				Action actionType = listener.actionType;
				Action toDo = null;
				if(actionType instanceof AttackAction){
					//TODO:Have user choose unit to attack
					toDo = new AttackAction(1, (Unit)environ.getOwner(), null); //TODO:Replace with user-selected entity
				}
				else if(actionType instanceof MoveAction){
					//TODO:Have user choose space to move to
					toDo = new MoveAction(1, (Unit)environ.getOwner(), null); //TODO:Replace with user-selected entity
				}
				Statement toAdd = new ActionStatement(toDo);
				environ.getLines().addAtEnd(toAdd);
				model.addElement(new StatementDisplay(toAdd, toAdd.toString()));
			}
			else if(selected.getStatement()==null){
				//No statements yet.  Delete placeholder, then add statement
				list.remove(list.getSelectedIndex());
				//TODO:Bring up list of possible options (Action, Loop, etc.)
				StatementType type = StatementType.ACTION; //TODO: Replace with chosen option.
				//TODO:Make less hacky
				tempList = new JList<Action>(((ScriptButton)e.getSource()).getOptions());
				tempList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tempList.setSelectedIndex(0);
				OptionListener listener = new OptionListener();
				tempList.addListSelectionListener(listener);
				tempList.setVisibleRowCount(5);
				JScrollPane pane = new JScrollPane(tempList);
				//TODO: Wait somehow for user input
				Action actionType = listener.actionType;
				Action toDo = null;
				if(actionType instanceof AttackAction){
					//TODO:Have user choose unit to attack
					toDo = new AttackAction(1, (Unit)environ.getOwner(), null); //TODO:Replace with user-selected entity
				}
				else if(actionType instanceof MoveAction){
					//TODO:Have user choose space to move to
					toDo = new MoveAction(1, (Unit)environ.getOwner(), null); //TODO:Replace with user-selected entity
				}
				Statement toAdd = new ActionStatement(toDo);
				environ.getLines().addAtEnd(toAdd);
				model.addElement(new StatementDisplay(toAdd, toAdd.toString()));
			}
			else{
				//Add after selected statement
				//TODO:Bring up list of possible options (Action, Loop, etc.)
				StatementType type = StatementType.ACTION; //TODO: Replace with chosen option.
				//TODO:Make less hacky
				tempList = new JList<Action>(((ScriptButton)e.getSource()).getOptions());
				tempList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tempList.setSelectedIndex(0);
				OptionListener listener = new OptionListener();
				tempList.addListSelectionListener(listener);
				tempList.setVisibleRowCount(5);
				JScrollPane pane = new JScrollPane(tempList);
				//TODO: Wait somehow for user input
				Action actionType = listener.actionType;
				Action toDo = null;
				if(actionType instanceof AttackAction){
					//TODO:Have user choose unit to attack
					toDo = new AttackAction(1, (Unit)environ.getOwner(), null); //TODO:Replace with user-selected entity
				}
				else if(actionType instanceof MoveAction){
					//TODO:Have user choose space to move to
					toDo = new MoveAction(1, (Unit)environ.getOwner(), null); //TODO:Replace with user-selected entity
				}
				Statement toAdd = new ActionStatement(toDo);
				int index = model.lastIndexOf(selected);
				environ.getLines().addStatement(toAdd,index);
				model.add(index, new StatementDisplay(toAdd, toAdd.toString()));
			}
		}
	}

	class StatementDisplay {
		protected Statement statement;
		protected String description;

		public StatementDisplay(Statement state, String desc){
			statement = state;
			description = desc;
		}

		public Statement getStatement(){
			return statement;
		}

		public String getDescription(){
			return description;
		}

		public String toString(){ //Possibly used by JList?
			return description;
		}
	}


}