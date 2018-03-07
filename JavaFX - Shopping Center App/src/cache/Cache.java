package cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	private static Map<String,Object> cache;
	static{
		cache = new HashMap<>();
	}
	public Cache() {
	}
	
	public void put(String key, Object value){
		cache.put(key, value);
	}
	
	public Object get(String key){
		return cache.get(key);
	}

}
