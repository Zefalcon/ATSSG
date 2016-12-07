package ATSSG;

import java.util.HashMap;

/**
 * Created by Evelyn Moss on 11/16/2016.
 */
@SuppressWarnings("serial")
public class InlineMap<K, V> extends HashMap<K, V> {
		public InlineMap<K,V> returnPut(K key, V value){
			this.put(key, value);
			return this;
		}
}
