import java.util.*;
import java.io.*;

public class HashTable {

	public static void main(String[] args) {
		String[] data = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(data));
	}

	/**
	 * Given an array of strings, group anagrams together
	 * https://leetcode.com/problems/anagrams/
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null) {
			return new ArrayList<>();
		}

		int len = strs.length;
		boolean[] collected = new boolean[len];

		List<List<String>> result = new ArrayList<>();

		for (int i = 0; i < len; ++i) {
			if (collected[i]) {
				continue;
			}

			List<String> group = new ArrayList<>();
			group.add(strs[i]);
			collected[i] = true;

			for (int j = i + 1; j < len; ++j) {
				if (collected[j]) {
					continue;
				}
				
				if (isAnagram(strs[i], strs[j])) {
					group.add(strs[j]);
					collected[j] = true;
				}
			}

			result.add(group);
		}

		return result;
	}

	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();

		for (char c : a.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}

			map.put(c, map.get(c) + 1);
		}

		for (char c : b.toCharArray()) {
			if (!map.containsKey(c)) {
				return false;
			}

			map.put(c, map.get(c) - 1);
			if (map.get(c) == 0) {
				map.remove(c);
			}
		}

		return map.isEmpty();
	}
}
