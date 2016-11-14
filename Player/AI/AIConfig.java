package ATSSG.Player.AI;

public class AIConfig {
	public final AttackMode target_style;
	public final double focus_bonus;
	
	public AIConfig() {
		this(AttackMode.RANDOM, 0.0);
	}

	public AIConfig(AttackMode target_style, double focus) {
		this.target_style = target_style;
		this.focus_bonus = focus;
	}
	
	public enum AttackMode {
		RANDOM(),
		CLOSEST();
	}
}
