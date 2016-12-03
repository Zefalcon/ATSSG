package ATSSG.Player.AI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import ATSSG.Actions.Action;
import ATSSG.Cell;
import ATSSG.EstimatingCell;
import ATSSG.Entities.Entity;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Unit;

public class MoveMeta extends MetaAction {
	protected Unit actor;
	protected Cell dest;
	protected List<Cell> path;
	public static final int MAXCOST = 20;
	
	public MoveMeta(Cell destination, Unit actor) {
		this.actor = actor;
		dest = destination;
		path = planPath();
	}
	
	protected List<Cell> planPath () {
		double heuristic= 1.5;
		PriorityQueue<EstimatingCell> toCheck = new PriorityQueue<EstimatingCell>();
		toCheck.add(new EstimatingCell(actor.getContainingCell(), 0, dest, new ArrayList<Cell>(), heuristic));
		HashSet<Cell> reachedCells = new HashSet<Cell>();
		reachedCells.add(actor.getContainingCell());
		while (!toCheck.isEmpty()) {
			EstimatingCell current = toCheck.remove();
			if (current.getCell().equals(dest) || current.getCost() > MAXCOST) {
				List<Cell> path = current.getPath();
				if (path.size() >0) path.remove(path.size()-1);
				return path;
			}
			for (Cell possMove : current.getCell().getAdjacent()) {
				if (possMove == dest) {
					return current.getPath();
				}
				if(actor.isPassable(possMove) && !reachedCells.contains(possMove)) {
					List<Cell> newPath = new ArrayList<Cell>(current.getPath());
					newPath.add(possMove);
					toCheck.add(new EstimatingCell(possMove, current.getCost()+
							actor.getType().passableTerrain.get(possMove.getTerrainType()), dest, newPath, heuristic));
					reachedCells.add(possMove);
				}
			}
		}
		return null;
	}
	
	public boolean pathInvalid() {
		return path == null || path.isEmpty() || !actor.isPassable(path.get(0));
	}
	
	public Action nextAction() {
		if (isDone()) return null;
		if (pathInvalid()) path = planPath();
		if (pathInvalid()) return null;
		int movesLeft = actor.getType().maxMoves;
		Cell next = path.get(0);
		while (!path.isEmpty() && movesLeft > actor.getType().passableTerrain.get(path.get(0).getTerrainType())) {
			next = path.remove(0);
			movesLeft -= actor.getType().passableTerrain.get(next.getTerrainType());
			
		}
		return new MoveAction(1, actor, next);
	}

	@Override
	public Boolean isDone() {
		return actor.getContainingCell().getX() == dest.getX() && actor.getContainingCell().getY() == dest.getY();
	}
}