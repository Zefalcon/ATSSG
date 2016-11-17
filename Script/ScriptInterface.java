package ATSSG.Script;
import java.util.Collection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import ATSSG.Button;
import ATSSG.Overlay;
import ATSSG.Player.Player;

public class ScriptInterface extends Overlay implements ListSelectionListener{
	
	//Variables
	
	protected Collection<Button> scriptElements;
	protected Button execute;
	protected Collection<?> assemblyZone;

	protected JList list;
	protected DefaultListModel model;

	//Constructors
	
	public ScriptInterface(Collection<Object> content, int width, int height, Player owner) {
		super(content, width, height, owner);

		ScriptButton addActionButton = new ScriptButton(null, owner);
		//TODO:Set action command to "Add Action"
		//TODO:Add new StatementListener as ActionListener
		//TODO:Set enabled
		scriptElements.add(addActionButton);

		model = new DefaultListModel();
		model.addElement(new StatementDisplay(new ActionStatement(null), "No Statements"));

		list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(5);
		JScrollPane scroll = new JScrollPane(list);

		view = new JPanel();
		view.setPreferredSize(getSize());
		view.add(addActionButton.getGooey());
		view.setVisible(true);
		view.add(scroll, BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

	//Methods

	class StatementListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StatementDisplay selected = (StatementDisplay)list.getSelectedValue();
			if(selected == null){
				//Add at end
				//TODO:Bring up list of possible options
				//TODO:Create new Statement with given options
				//TODO:Add Statement to Block
				//TODO:Add Statement (in form of StatementDisplay) to list
			}
			else if(selected.getStatement()==null){
				//No statements yet.  Delete placeholder, then add statement
				list.remove(list.getSelectedIndex());
				//TODO:Bring up list of possible options
				//TODO:Create new Statement with given options
				//TODO:Add Statement to Block
				//TODO:Add Statement (in form of StatementDisplay) to list
			}
			else{
				//Add after selected statement
				//TODO:Bring up list of possible options
				//TODO:Create new Statement with given options
				//TODO:Add Statement to Block after selected statement
				//TODO:Add Statement (in form of StatementDisplay) to list after selected statement
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
	}


}