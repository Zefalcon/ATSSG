package ATSSG.Script.Framework;

import java.util.HashMap;

import ATSSG.Entities.Entity;

public class Script {
	
	//Variables
	protected Block lines;
	protected HashMap<String, Object> heap;
	protected Entity owner;
	
	public Block getLines() {
		return lines;
	}

	public HashMap<String, Object> getHeap() {
		return heap;
	}

	public Entity getOwner() {
		return owner;
	}

	//Constructors
	public Script(Entity owner) {
		this.owner = owner;
		lines = new Block();
		heap = new HashMap<String, Object>();
	}
	
	//Methods
	public boolean execute() throws ScriptError{
		return lines.execute(this);
	}
	
	public String saveString(){
		return lines.saveString(0);
	}
}
