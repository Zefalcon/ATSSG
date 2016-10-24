package ATSSG;

public interface Saveable {
	
	//Methods
	public byte[] Save();
	
	public static Saveable Load(byte[] input){
		return null;
	}

}
