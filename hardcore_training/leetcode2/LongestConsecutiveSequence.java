import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] data = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(data));
	}

	public static int longestConsecutive(int[] data) {
		/* The first solution has trouble with large input */
		int ret = -1;
		Map<Integer, Integer> map = new HashMap<>();

		for (int it : data) {
			map.put(it, 0);
		}

		for (int it : map.keySet()) {
			longestConsecutive(map, it);

		}

		for (int it : map.values()) {
			ret = Math.max(ret, it);
		}

		return ret;
	}

	public static int longestConsecutive(Map<Integer, Integer> map, int num) {
		if (map.get(num) != 0) {
			return 0;
		}
		
		if (!map.containsKey(num + 1)) {
			map.put(num, 1);
		}
		else {
			longestConsecutive(map, num + 1);
			map.put(num, 1 + map.get(num + 1));
		}

		return 0;
	}
}
