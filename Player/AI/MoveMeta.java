package ATSSG.Player.AI;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import ATSSG.Actions.Action;
import ATSSG.Cell;
import ATSSG.Entities.Entity;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Unit;

public class MoveMeta extends MetaAction {
	protected Unit actor;
	protected Cell dest;
	protected List<Cell> path;
	public static final int MAXPLAN = 20;
	
	public MoveMeta(Cell destination, Unit actor) {
		this.actor = actor;
		dest = destination;
		path = planPath();
	}
	
	protected List<Cell> planPath () {
		PriorityQueue<RecordCell> toCheck = new PriorityQueue<RecordCell>();
		toCheck.add(new RecordCell(actor.getContainingCell(), 0, dest, new ArrayList<Cell>()));
		while (!toCheck.isEmpty()) {
			RecordCell current = toCheck.remove();
			if (current.equals(dest) || current.getPath().size() >= MAXPLAN) {
				return current.getPath();
			}
			for (Cell possMove : current.getCell().getAdjacent()) {
				List<Cell> newPath = new ArrayList<Cell>(current.getPath());
				newPath.add(possMove);
				//TODO: change values for high cost terrain				
				RecordCell child = new RecordCell(possMove, current.getCost()+1, dest, newPath);
				if(isPassable(possMove)) {
					boolean toAdd = true;
					//Verify not repeat
					for (RecordCell c: toCheck) {
						if (c.equals(possMove)) {
							if (child.compareTo(c) > 0) {
								toCheck.remove(c);
							} else {
								toAdd = false;
							}
							break;
						}
					}
					if (toAdd) {
						toCheck.add(child);
					}
				}
			}
		}
		return null;
	}
	
	public boolean isPassable(Cell c) {
		boolean enemy = false;
		for (Entity ent : c.getOccupyingEntities()) {
			if (ent.getOwner() != actor.getOwner()) {
				enemy = true;
				break;
			}
		}
		//Currently Assuming only in list if passable
		return actor.getType().passableTerrain.containsKey(c.getTerrainType()) && !enemy;
	}
	
	public boolean pathInvalid() {
		return path == null || path.isEmpty() || !isPassable(path.get(0));
	}
	
	public Action nextAction() {
		if (isDone()) return null;
		if (pathInvalid()) path = planPath();
		if (pathInvalid()) return null;
		return new MoveAction(1, actor, path.remove(0)); // TODO: replace with code that can take multiple turns
	}

	@Override
	public Boolean isDone() {
		return actor.getContainingCell().getX() == dest.getX() && actor.getContainingCell().getY() == dest.getY();
	}
}

class RecordCell implements Comparable {
	protected Cell current;
	protected List<Cell> path;
	protected int cost;
	protected int estimate;
	
	public RecordCell(Cell cell, int cost, Cell dest, List<Cell> path) {
		this.path = path;
		current = cell;
		this.cost = cost;
		this.estimate = cost + 2*Math.max(Math.abs(dest.getX()-cell.getX()), Math.abs(dest.getY()-cell.getY()));
	}
	
	public boolean equals(RecordCell other) {
		return current.equals(other.getCell());
	}
	
	public Cell getCell() { return current;}
	public int getCost() {return cost;}
	public int getEstimate() {return estimate;}
	public List<Cell> getPath() {return path;}

	public int compareTo(Object arg0) {
		return estimate - ((RecordCell) arg0).getEstimate();
	}
}