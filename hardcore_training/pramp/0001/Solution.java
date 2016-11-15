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

	/* Floor: less than or equal value  */
	public static Node floor(Node root, int val) {
		
		if (root == null) {
			return null;
		}

		Node result = null;

		Node iterator = root;
		while (iterator != null) {
			if (iterator.val == val) {
				result = iterator;
				break;
			} else if (val < iterator.val) {
				iterator = iterator.left;
			} else {
				result = iterator;
				iterator = iterator.right;
			}
		}

		return result;
	}
}

class Node {

	int val;
	Node left, right;
}
