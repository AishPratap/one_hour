import java.util.*;

public class Solution {
	
	public static void main(String[] args) {

	}

	public static Map<String, Integer> flattenMap(Map<String, Object> map) {
		Map<String, Integer> result = new HashMap<>();
		flat(null, map, result);
		return result;
	}

	public static void flat(String preKey, Map<String, Object> origin,
			Map<String, Integer> result) {
		for (Map.Entry<String, Object> iterator : origin.entrySet()) {
			String key = preKey == null ?
				iterator.getKey() :
				preKey + "." + iterator.getKey();

			if (iterator.getValue() instanceof Integer) {
				result.put(key, (Integer) iterator.getValue());
			} else {
				flat(key, (Map<String, Object>) iterator.getValue(), result);
			}
		}	
	}
}
