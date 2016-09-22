import java.util.*;

public class Chap00 {

	public static void main(String[] args) {
		String str0 = "khoi";
		String str1 = "oikhoi";
		System.out.println(isRotation(str0, str1));
	}

	/**
	 * Implement an algorithm to determine if a string 
	 * has all unique character
	 * Supposed that there is only a-z and case insensitive
	 * Complexity: O(n)
	 */
	public static boolean hasUniqueCharacters(String str) {
		HashSet<Character> set = new HashSet<>();
		for(char c : str.toCharArray()) {
			if(set.contains(c)) {
				return false;
			} else {
				set.add(c);
			}
		}

		return true;
	}

	/**
	 * No additional data structures
	 * Supposed that there is only a-z case
	 * Complexity: O(n)
	 */
	public static boolean hasUniqueCharacters2(String str) {
		int set = 0;
		for(char c : str.toCharArray()) {
			int index = c- 'a';
			if (isBitSet(index, set)) {
				return false;
			} else {
				set = setBitAt(index, set);
			}
		}

		return true;
	}

	/**
	 * Same as above, but this is a naive version
	 * Complexity: O(n^2)
	 */
	public static boolean hasUniqueCharacters3(String str) {
		for(int i = 0; i < str.length(); ++i) {
			for (int j = i + 1; j < str.length(); ++j) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isBitSet(int index, int set) {
		int mask = 1 << index;
		return (set & mask) != 0;
	}

	public static int setBitAt(int index, int set) {
		int mask = 1 << index;
		return (set | mask);
	}

	/**
	 * Given two strings, decide if they are permutation of each other
	 * Complexity: O(n)
	 */
	public static boolean isPerm(String str0, String str1) {
		if (str0.length() != str1.length()) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : str0.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		for(char c : str1.toCharArray()) {
			if (!map.containsKey(c)) {
				return false;
			} else {
				map.put(c, map.get(c) - 1);
				if (map.get(c) <= 0) {
					map.remove(c);
				}
			}
		}

		return map.isEmpty();
	}

	/**
	 * Character range: a-z
	 */
	public static boolean isPerm2(String str0, String str1) {
		if (str0.length() != str1.length()) {
			return false;
		}
		int[] counter = new int[26];
		for(char c : str0.toCharArray()) {
			counter[c - 'a'] += 1;
		}
		for(char c : str1.toCharArray()) {
			counter[c - 'a'] -= 1;
		}

		for(int i : counter) {
			if (i != 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Replace spaces with 200, this array of string can hold all of them
	 * This action must be done in place
	 * Complexity: O(n)
	 */

	public static void replace200(char[] str, int len) {
		int p1 = len - 1;
		/* Count number of spaces */
		int spaceCount = 0;
		for(char c : str) {
			if (c == ' ') {
				spaceCount += 1;
			}
		}
		
		if (spaceCount == 0) {
			return str;
		}

		int p2 = len + spaceCount * 2 - 1;
		for(;p1 >= 0; --p1) {
			if (str[p1] == ' ') {
				str[p2--] = '0';
				str[p2--] = '0';
				str[p2--] = '2';
			} else {
				str[p2--] = str[p1];
			}
		}
	}
	
	/**
	 * Compress a string
	 * Ex: aabbcccc would become a2b2c4
	 * If the origin is shorter, keep it
	 */
	public static String compress(String str) {
		StringBuilder builder = new StringBuilder();
		int counter = 0;
		char current = 0;
		for(char c : str.toCharArray()) {
			if (c != current) {
				if (current != 0) {
					builder.append(current)
						.append(counter);
				}
				current = c;
				counter = 1;
			} else {
				counter += 1;
			}
		}
		builder.append(current).append(counter);
		String compressed = builder.toString();
		return compressed.length() < str.length() ? compressed : str;
	}
	
	/**
	 * If one element in that matrix is zero
	 * Entire row and column must be zero
	 * Complexity: O(n*m)
	 */
	public static void zerotify(int[][] matrix) {
		HashSet<Integer> rowSet = new HashSet<>();
		HashSet<Integer> colSet = new HashSet<>();

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}
		
		for (int rowIt : rowSet) {
			for (int i = 0; i < matrix[0].length; ++i) {
				matrix[rowIt][i] = 0;
			}
		}

		for (int colIt : colSet) {
			for (int i = 0; i < matrix.length; ++i) {
				matrix[i][colIt] = 0;
			}
		}
	}
	
	/**
	 * Check if two strings are the rotation of each other
	 */
	public static boolean isRotation(String str0, String str1) {
		if (str0.length() != str1.length()) {
			return false;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(str0).append(str0);
		return builder.toString().contains(str1);
	}
}
