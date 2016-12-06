import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String str = "thequickfoxjumpsoveralazydog";
		
		String result = longestUniqueSubstring(str);

		System.out.println(result);
	}

	/**
	 * Given a string, find the longest substring that contains unique
	 * characters
	 *
	 * Suppose that the charset is only 26 characters
	 * So, it would take O(26n) = O(n) time complexity
	 * Space: O(26) = O(1)
	 */
	public static String longestUniqueSubstring(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}

		int p0 = 0, p1 = 0;
		int max = -1, start = 0, end = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		map.put(str.charAt(0), 1);

		while (p1 < str.length()) {
			if (isUnique(map)) {
				if (p1 - p0 > max) {
					max = p1 - p0;
					start = p0;
					end = p1;
				}

				p1 += 1;

				if (p1 < str.length()) {
					char next = str.charAt(p1);
					if (!map.containsKey(next)) {
						map.put(next, 0);
					}

					map.put(next, map.get(next) + 1);
				}

			} else {
				char remove = str.charAt(p0);
				map.put(remove, map.get(remove) - 1);
				p0 += 1;
			}
		}
		return str.substring(start, end + 1);
	}

	public static boolean isUnique(Map<Character, Integer> map) {
		for (Map.Entry<Character, Integer> it : map.entrySet()) {
			if (it.getValue() > 1) {
				return false;
			}
		}

		return true;
	}
}
