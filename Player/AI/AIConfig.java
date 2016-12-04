package ATSSG.Player.AI;

public class AIConfig {
	public final double dist_mult;
	public final double focus_bonus;
	public final double hp_mult;
	
	public AIConfig() {
		this(1.0, 0.0, 0.0);
	}

	public AIConfig(double dist_mult, double focus_bonus, double hp_mult) {
		this.dist_mult = dist_mult;
		this.focus_bonus = focus_bonus;
		this.hp_mult = hp_mult;
	}
	
	public boolean isRandom() {
		return dist_mult == 0 && focus_bonus == 0 && hp_mult == 0;
	}
	
}
