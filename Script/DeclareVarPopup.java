package ATSSG.Script;

import java.awt.*;
import java.awt.event.*;

import ATSSG.Script.Framework.*;

/**
 * Created by Evelyn Moss on 12/4/2016.
 */
@SuppressWarnings("serial")
public class DeclareVarPopup extends Dialog implements ActionListener{
	ScriptInterface inter;

	Label variable;
	Label type;
	Button addButton;

	TextField var;

	Choice options;

	public DeclareVarPopup(ScriptInterface owner){
		super(owner);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				we.getWindow().setVisible(false);
			}});
		inter = owner;

		setLayout(new FlowLayout());
		variable = new Label("Variable Name");
		type = new Label("Type");

		addButton = new Button("Add Statement");
		addButton.addActionListener(this);

		var = new TextField("[Name]");
		options = new Choice();
		options.add("Double");
		options.add("Boolean");

		add(variable);
		add(var);
		add(type);
		add(options);

		add(addButton);

		setTitle("Declare Variable");
		setSize(250, 100);
	}

	public void actionPerformed(ActionEvent e){
		String choice = options.getSelectedItem();
		Class<?> chosenType;
		if(choice.equals("Double")){
			chosenType = Double.class;
		}
		else if(choice.equals("Boolean")){
			chosenType = Boolean.class;
		}
		else{
			//Should NOT get here.  Default to double
			chosenType = Double.class;
		}
		Statement toAdd;
		try{
			toAdd = new VariableDeclarationStatement(var.getText(), chosenType);
		}
		catch(ScriptError se){
			System.out.println(se.getStackTrace());
			return;
		}
		inter.addAtPointer(toAdd);
		this.setVisible(false);
	}
}
