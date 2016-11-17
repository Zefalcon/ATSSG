package ATSSG;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Evelyn Moss on 11/16/2016.
 */
public class InlineMap<K, V> extends HashMap<K, V> {
		public InlineMap<K,V> returnPut(K key, V value){
			this.put(key, value);
			return this;
		}
}
