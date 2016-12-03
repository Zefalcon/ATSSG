package ATSSG;

import java.nio.ByteBuffer;

public class Saveable {
	public static final int ict = (Integer.SIZE / Byte.SIZE);
	
	public static byte[] itob(int x){
		return ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).putInt(x).array();
	}
}