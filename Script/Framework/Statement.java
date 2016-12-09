package ATSSG.Script.Framework;

import java.util.ArrayList;
import java.util.List;

import ATSSG.Enums.CommandType;
import ATSSG.Script.Framework.DataAccessStatement.AccessType;

public abstract class Statement {
		
	//Methods
	/**
	 * @return true if the execute set the unit's actions
	 * @throws ScriptError
	 */
	public abstract boolean execute(Script environment) throws ScriptError;
	
	/**
	 * 
	 * @return true if the statement does not need another turn
	 */
	public abstract boolean statementDone();
	
	public abstract Statement copy();
	
	public abstract String saveString(int depth);
	
	public static Statement make(String line, int d){
		//System.out.println("Making from " + line);
		if(line.charAt(0) == '('){
			int d_prime = Integer.parseInt(line.substring(line.indexOf('('), line.indexOf(')') - 1));
			//System.out.println("Making a new block at depth " + d_prime + " with string " + line.substring(3, line.length() - 3));
			return new Block(line.substring(3, line.length() - 3), d_prime);
		}
		else{
			String tag = line.substring(0, line.indexOf(':'));
			String rest = line.substring(line.indexOf(':') + 1);
			//System.out.println("Collected tag " + tag);
			switch(tag){
				case "set":
					String name_found = rest.substring(0, rest.indexOf(','));
					String valu_found = rest.substring(rest.indexOf(',')+1);
					//System.out.println("Creating variable setter with name " + name_found + " and value " + valu_found);
					return new SetVariableStatement(name_found, valu_found);
					
				case "dec":
					String name_found_2 = rest.substring(0, rest.indexOf(','));
					String type_found = rest.substring(rest.indexOf(',')+1);
					//System.out.println("Creating variable declaration with name " + name_found_2 + " and value " + type_found);
					try{
						return new VariableDeclarationStatement(name_found_2, Class.forName(type_found));
					}catch(ScriptError | ClassNotFoundException x){
						//Silently drop.
					}
					
				case "das":
					String ord_string = rest.substring(0, rest.indexOf(','));
					String rest_cut = rest.substring(rest.indexOf(',') + 1);
					String args_string = rest_cut.substring(0, rest_cut.indexOf(','));
					String vn_string = rest_cut.substring(rest_cut.indexOf(',') + 1);
					
					//System.out.println("Making data assigner with ordinal " + ord_string + " and arguments " + args_string + " and varname " + vn_string);
					
					List<String> args = new ArrayList<String>();
					int scp = args_string.indexOf(';');
					while(scp != -1){
						args.add(args_string.substring(0, scp));
						args_string = args_string.substring(scp + 1);
						scp = args_string.indexOf(';');
					}
					return new DataAccessStatement(AccessType.values()[Integer.parseInt(ord_string)], vn_string, args);
					
				case "act":
					String enu_string = rest.substring(0, rest.indexOf(','));
					String arg_string = rest.substring(rest.indexOf(',') + 1);
					//System.out.println("Making action with ordinal " + enu_string + " and arguments " + arg_string);
					
					List<String> args_prime = new ArrayList<String>();
					int scp_prime = arg_string.indexOf(';');
					//System.out.println("Argflag is " + scp_prime);
					while(scp_prime != -1){
						args_prime.add(arg_string.substring(0, scp_prime));
						arg_string = arg_string.substring(scp_prime + 1);
						scp_prime = arg_string.indexOf(';');
					}
					
					return new ActionStatement(CommandType.values()[Integer.parseInt(enu_string)], args_prime);
					
				case "loop":
					int depth_prime = d + 1;
					String deep_tag = "(" + Integer.toString(depth_prime) + ")";
					rest = rest.substring(deep_tag.length());
					String obody_string = rest.substring(0, rest.indexOf(deep_tag));
					rest = rest.substring(rest.indexOf(deep_tag) + deep_tag.length());
					String condition_string = rest.substring(rest.indexOf(deep_tag) + deep_tag.length() + 1);
					
					//System.out.println("Creating loop with obody " + obody_string + " and condition " + condition_string);
					return new LoopStatement(Statement.make(obody_string, depth_prime), condition_string);
					
				case "con":
					int depth_prime_ = d + 1;
					String deep_tag_ = "(" + Integer.toString(depth_prime_) + ")";
					rest = rest.substring(deep_tag_.length());
					String true_string = rest.substring(0, rest.indexOf(deep_tag_));
					rest = rest.substring(rest.indexOf(deep_tag_) + deep_tag_.length());
					String false_string = rest.substring(0, rest.indexOf(deep_tag_));
					rest = rest.substring(rest.indexOf(deep_tag_) + deep_tag_.length());
					String condition = rest.substring(1);
					
					//System.out.println("Creating if with true " + true_string + "false " + false_string +  " and condition " + condition);
					
					return new ControlStatement(
						Statement.make(true_string, depth_prime_),
						Statement.make(false_string, depth_prime_),
						condition
					);
				default:
					return null;
			}
		}
	}
}