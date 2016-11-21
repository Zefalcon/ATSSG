package ATSSG.Script.Framework;

public class Expression {
	
	public static Double getDoubleValue(String source, Script environment) {
		source = source.trim();
		//TODO: Parse varied expressions
		return Double.parseDouble(source);
	}
	
	public static Boolean getBooleanValue(String source, Script environment) {
		source = source.trim();
		//TODO: Parse varied expressions
		return Boolean.parseBoolean(source);
	}

}
