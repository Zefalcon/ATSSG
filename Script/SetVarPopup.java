package ATSSG.Script;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ATSSG.Script.Framework.*;

/**
 * Created by Evelyn Moss on 12/4/2016.
 */
public class SetVarPopup extends Dialog implements ActionListener  {

	ScriptInterface inter;

	Label variable;
	Label value;
	Button addButton;

	TextField var;
	TextField val;

	public SetVarPopup(ScriptInterface owner){
		super(owner);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				we.getWindow().setVisible(false);
			}});
		inter = owner;

		setLayout(new FlowLayout());
		variable = new Label("Variable Name");
		value = new Label("Value");

		addButton = new Button("Add Statement");
		addButton.addActionListener(this);

		var = new TextField("[Name]");
		val = new TextField("[Value]");

		add(variable);
		add(var);
		add(value);
		add(val);
		add(addButton);

		setTitle("Set Variable");
		setSize(250, 100);
	}

	public void actionPerformed(ActionEvent e){
		Statement toAdd = new SetVariableStatement(var.getText(), val.getText());
		inter.addAtPointer(toAdd);
		this.setVisible(false);
	}
}
