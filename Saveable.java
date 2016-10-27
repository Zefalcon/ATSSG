package ATSSG;

public interface Saveable {
	
	//Methods
	public byte[] Save();
	
	public Saveable Load(byte[] input);

}
