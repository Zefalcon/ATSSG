package ATSSG;

import java.util.List;

public class EstimatingCell implements Comparable<EstimatingCell> {
	protected Cell current;
	protected List<Cell> path;
	protected int cost;
	protected double estimate;
	
	public EstimatingCell(Cell cell, int cost, Cell dest, List<Cell> path, double heuristic) {
		this.path = path;
		current = cell;
		this.cost = cost;
		this.estimate = cost + heuristic*Cell.distance(cell, dest);
	}
	
	public boolean equals(EstimatingCell other) {
		return current.equals(other.getCell());
	}
	
	public Cell getCell() { return current;}
	public int getCost() {return cost;}
	public double getEstimate() {return estimate;}
	public List<Cell> getPath() {return path;}

	public int compareTo(EstimatingCell arg0) {
		return (int) (estimate - arg0.getEstimate());
	}
}