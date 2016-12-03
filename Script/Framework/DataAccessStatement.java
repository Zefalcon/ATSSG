package ATSSG.Script.Framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;

public class DataAccessStatement extends Statement {
	
	protected AccessType type;
	protected List<String> arguments;
	protected String varname;

	public DataAccessStatement(AccessType orig_type, String varname, List<String> orig_arguments) {
		if (orig_type == null) orig_type = AccessType.Current_HP;
		type = orig_type;
		if (orig_arguments == null) orig_arguments = new ArrayList<String>();
		arguments = orig_arguments;
		this.varname = varname;
	}

	@Override
	public boolean execute(Script environment) throws ScriptError {
		Object value =null;
		switch (type) {
		case Cell_Cost:
			value = ((Unit)getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), 
					environment)).getType().passableTerrain.get(
					environment.getOwner().getOwner().getContaining_map().getCell(
					Expression.getDoubleValue(arguments.get(1), environment).intValue(), 
					Expression.getDoubleValue(arguments.get(2), environment).intValue()));
			break;
		case Current_HP:
			value = getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment).getHitPoints();
			break;
		case Damage:
			value = ((Unit)getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment)).getType().aDamage;
			break;
		case IsCellPassable:
			value = new Boolean(((Unit)getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), 
					environment)).getType().passableTerrain.containsKey(
					environment.getOwner().getOwner().getContaining_map().getCell(
					Expression.getDoubleValue(arguments.get(1), environment).intValue(), 
					Expression.getDoubleValue(arguments.get(2), environment).intValue())));
			break;
		case Is_Alive:
			value = new Boolean(getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment) == null);
			break;
		case Is_Enemy:
			break;
		case Maximum_HP:
			value = ((Unit)getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment)).getType().maxHP;
			break;
		case Maximum_Moves:
			value = ((Unit)getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment)).getType().maxMoves;
			break;
		case Maximum_valid_id:
			value = Entity.getNextId()-1;
			break;
		case My_ID:
			value = environment.getOwner().getId();
			break;
		case Range:
			value = ((Unit)getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment)).getType().aRange;
			break;
		case X_Loc:
			getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment).getContainingCell().getX();
			break;
		case Y_Loc:
			getEntity(Expression.getDoubleValue(arguments.get(0), environment).intValue(), environment).getContainingCell().getY();
			break;
		default:
			throw new ScriptError(environment, this, "Unimplemented AccessType: "+type);
		}
		environment.getHeap().put(varname, value);
		return false;
	}
	
	protected Entity getEntity(int id, Script environment) {
		for (Entity e : environment.getOwner().getOwner().getContaining_map().getEntities()) {
			if (e.getId() == id) return e;
		}
		return null;
	}

	@Override
	public boolean statementDone() {
		return true;
	}

	@Override
	public Statement copy() {
		return new DataAccessStatement(type, varname+"", new ArrayList<String>(arguments));
	}

	public AccessType getType() {
		return type;
	}

	public void setType(AccessType type) {
		this.type = type;
	}

	public List<String> getArguments() {
		return arguments;
	}

	public void setArguments(List<String> arguments) {
		this.arguments = arguments;
	}
	
	public String getVarname() {
		return varname;
	}

	public void setVarname(String varname) {
		this.varname = varname;
	}
	
	public enum AccessType {
		Current_HP("Current HP", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		Maximum_HP("Maximum HP", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		Maximum_Moves("Maximum Moves", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		Range("Unit Range", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		Damage("Unit Damage", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		My_ID("Select unit's id", new ArrayList<Class<?>>(), new ArrayList<String>()),
		Is_Alive("Is unit Alive", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		Is_Enemy("Is unit enemy", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		Maximum_valid_id("Unit Damage", new ArrayList<Class<?>>(), new ArrayList<String>()),
		X_Loc("X Location", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		Y_Loc("Y_Location", new ArrayList<Class<?>>(Arrays.asList(Double.class)), Arrays.asList("Unit ID")),
		IsCellPassable("Cell passable by Unit", new ArrayList<Class<?>>(Arrays.asList(Double.class, Double.class, Double.class)), 
				Arrays.asList("Unit ID", "X", "Y")),
		Cell_Cost("Cost of passing by Unit", new ArrayList<Class<?>>(Arrays.asList(Double.class, Double.class, Double.class)), 
				Arrays.asList("Unit ID", "X", "Y"));
		
		public List<Class<?>> necessary_arguments;
		public List<String> argument_names;
		
		private AccessType(String name, List<Class<?>> necessary_arguments, List<String> argument_names) {
			this.necessary_arguments = necessary_arguments;
			this.argument_names = argument_names;
		}
		
	}

}
