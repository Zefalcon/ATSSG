package ATSSG.Entities;

import ATSSG.*;
import ATSSG.Entities.Building;
import ATSSG.Entities.Entity;
import ATSSG.Player.Player;

public class Unit extends Entity {
	
	//Variables
	protected UnitType type;
	
	//Constructors
	public Unit(UnitType t, Player player, Cell current){
		super(t.maxHP, player, current, t.getImage());
		type = t;
		allowedCommands.add(CommandType.IDLE);
		allowedCommands.add(CommandType.MOVE); //Flag Possibly these allowedCommands collections should exist in the UnitType/BuildingType enums instead of Entity?
		allowedCommands.add(CommandType.ATTACK);
	}
	//Methods
	public boolean canAttack(Entity target){
		if (target.getHitPoints() == 0) return false;
		return Cell.distance(getContainingCell(), target.getContainingCell()) <= type.aRange;
	}

	public boolean attack(Entity target){
		//If within range, hit
		if(canAttack(target)){
			target.doDamage((type.aDamage));
			return true;
		}
		else{
			return false;
		}
	}

	public boolean canMoveTo(Cell destination){
		boolean enemy = false;
		for (Entity ent : destination.getOccupyingEntities()) {
			if (ent.getOwner() != owner) {
				enemy = true;
				break;
			}
		}
		return Cell.distance(getContainingCell(), destination) <= type.maxMoves && !enemy 
				&& type.passableTerrain.containsKey(destination.getTerrainType());
	}
	
	public boolean move(Cell destination){
		if(canMoveTo(destination)){
			getContainingCell().removeEntity(this);
			destination.addOccupyingEntity(this);
			setContainingCell(destination);
			return true;
		}
		return false;
	}
	
	public UnitType getType() {return type;}
	//public UnitButton getButton() {return button;}

	public boolean build(BuildingType type){
		return false; //Units cannot build unless they are builder units
	}

	public boolean deposit(Building drop){
		return false; //Only harvesters can drop stuff
	}

	public boolean harvest(ResourceItem resource){
		return false; //Only harvesters can harvest stuff
	}

}