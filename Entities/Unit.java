package ATSSG.Entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import ATSSG.*;
import ATSSG.Entities.Building;
import ATSSG.Entities.Entity;
import ATSSG.Enums.BuildingType;
import ATSSG.Enums.UnitType;
import ATSSG.GUI.CommandType;
import ATSSG.Player.Player;

public class Unit extends Entity {
	
	//Variables
	protected UnitType type;
	
	//Constructors
	public Unit(UnitType t, Player player, Cell current) throws IOException {
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
		if (!isPassable(destination)) return false;
		PriorityQueue<EstimatingCell> toCheck = new PriorityQueue<EstimatingCell>();
		toCheck.add(new EstimatingCell(containingCell, 0, destination, new ArrayList<Cell>(), 1));
		HashSet<Cell> reachedCells = new HashSet<Cell>();
		reachedCells.add(containingCell);
		while (!toCheck.isEmpty()) {
			EstimatingCell current = toCheck.remove();
			if (current.getEstimate() > type.maxMoves) {
				return false;
			}
			if (current.getCell().equals(destination)) {
				return true;
			}
			for (Cell possMove : current.getCell().getAdjacent()) {
				List<Cell> newPath = new ArrayList<Cell>(current.getPath());
				newPath.add(possMove);
				if(isPassable(possMove) && !reachedCells.contains(possMove)) {
					if (possMove == destination) {
						return current.getCost()+type.passableTerrain.get(possMove.getTerrainType()) <= type.maxMoves;
					}
					toCheck.add(new EstimatingCell(possMove, current.getCost()+
							type.passableTerrain.get(possMove.getTerrainType()), destination, newPath, 1));
					reachedCells.add(possMove);
				}
			}
		}
		return false;
	}
	
	public boolean isPassable(Cell destination) {
		boolean enemy = false;
		for (Entity ent : destination.getOccupyingEntities()) {
			if (ent.getOwner() != owner) {
				enemy = true;
				break;
			}
		}
		return !enemy && type.passableTerrain.containsKey(destination.getTerrainType());
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

	public String toString(){
		return entity_id + ": " + type;
	}
	
	public UnitType getType() {return type;}

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