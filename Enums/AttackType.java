package ATSSG.Enums;
import java.util.Hashtable;
import java.util.Map;

public enum AttackType {
	
	STABBING("stabbing", new Hashtable<AttackType, Double>()),
	SHOOTING("shooting", new Hashtable<AttackType, Double>());
	
	
	
	public String name;
	public Map<AttackType, Double> advantageMultiplier;
	
	private AttackType(String n, Map<AttackType, Double> m){
		name = n;
		advantageMultiplier = m;
	}

}