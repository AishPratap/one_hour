import java.util.*;

public class Chap01 {

	public static void main(String[] args) {
		
	}

	/**
	 * Check if a string has all unique characters
	 * Time: O(n), Space: O(n)
	 */
	public static boolean hasUniqueCharacters(String string) {
		
		if (string == null || string.isEmpty()) {
			return true;
		}

		HashSet<Character> set = new HashSet<>();
		for (char c : string.toCharArray()) {
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}

		return true;
	}

	/**
	 * Same, but no additional data-structures
	 * Time: O(n); Space: O(1)
	 */
	public static boolean hasUniqueCharacters2(String string) {
		if (string == null || string.isEmpty()) {
			return true;
		}

		/* Assume the range is [a-z] */
		int set = 0;
		for (char c : string.toCharArray()) {
			int index = c - 'a';
			if (isOn(set, index)) {
				return false;
			}
			set = turnOn(set, index);
		}

		return true;
	}
	
	/**
	 * Turn on bit at a specific index
	 */
	public static int turnOn(int set, int index) {
		int mask = 1 << index;
		return set | mask;
	}
	
	/**
	 * Check if a bit is on
	 */
	public static boolean isOn(int set, int index) {
		int mask = 1 << index;
		return (set & mask) != 0;
	}
	
	/**
	 * Decide if two strings are permutation of each other
	 * Time: O(n); Space: O(1)
	 */
	public static boolean isPermuation(String str0, String str1) {
		if (
			str0 == null || 
			str1 == null ||
			str0.length() != str1.length()) {

			return false;
		}

		// Assume [a-z]
		int[] counter = new int[26];
		
		for (char c : str0.toCharArray()) {
			int index = c - 'a';
			counter[index] += 1;
		}

		for (char c : str1.toCharArray()) {
			int index = c - 'a';
			counter[index] -= 1;
			if (counter[index] < 0) {
				return false;
			}
		}

		for (int i = 0; i < 26; ++i) {
			if (counter[i] != 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Same as above but charset is unknow
	 * Time: O(n) ; Space O(n)
	 */
	public static boolean isPermuation2(String str0, String str1) {
		if (str0 == null || str1 == null ||
				str0.length() != str1.length()) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<>();
		
		for (char c : str0.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				int cur = map.get(c);
				map.put(c, cur + 1);
			}
		}

		for (char c : str1.toCharArray()) {
			if (!map.containsKey(c)) {
				return false;
			}

			int current = map.get(c);
			if (current == 1) {
				map.remove(c);
			} else {
				map.put(c, current - 1);
			}
		}
		return map.isEmpty();
	}

	/**
	 * Replace all spaces into '20'
	 * Time: O(n); Space: O(1)
	 */
	public static void replace20(char[] str, int len) {
		if (str == null || len == 0) {
			return;
		}

		// Calculate number of spaces
		int spaces = 0;
		for (char c : str) {
			if (c == ' ') {
				spaces += 1;
			}
		}

		int virtual = len + spaces - 1;
		for (int real = len - 1; real > 0; --real) {
			if (str[real] == ' ') {
				str[virtual--] = '0';
				str[virtual--] = '2';
			} else {
				str[virtual--] = str[real];
			}
		}
	}

	/**
	 * Compress a string: aabbcc beccomes a2b2c2
	 * If the compressed string is longer than origin, return origin
	 * Time: O(n); Space: O(1) ?
	 */
	public static String compress(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}

		int counter = 0;
		char cur = 0;
		StringBuilder builder = new StringBuilder();
		
		for (char c : str.toCharArray()) {
			if (c == cur) {
				counter += 1;
			} else {
				if (cur != 0) {
					builder.append(cur).append(counter);
				}

				counter = 1;
				cur = c;
			}
		}
		builder.append(cur).append(counter);
		String compressed = builder.toString();

		return str.length() < compressed.length() ? str : compressed;
	}

	/**
	 * Check if two strings are rotation of each other
	 */
	public static boolean isRotation(String str0, String str1) {
		if (str0 == null || str1 == null ||
				str0.length() != str1.length()) {
			return false;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(str0).append(str0);
		String doubleString = builder.toString();
		return doubleString.contains(str1);
	}

	/**
	 * Given a 2d matrix, if one element is zero, set the whole column
	 * and row to zero
	 */
	public static void setZero(int[][] matrix) {
		if (matrix == null ||
			(matrix.length == 1 && matrix[0].length == 1)) {
			return;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		ArrayList<Integer> rowsList = new ArrayList<>();
		ArrayList<Integer> colsList = new ArrayList<>();

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (matrix[i][j] == 0) {
					rowsList.add(i);
					colsList.add(j);
				}
			}
		}

		for (int irow : rowsList) {
			for (int j = 0; j < cols; ++j) {
				matrix[irow][j] = 0;
			}
		}
		for (int icol : colsList) {
			for (int i = 0; i < rows; ++i) {
				matrix[i][icol] = 0;
			}
		}
	}
	public static String toString(int[][] matrix) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < matrix.length; ++i) {
			boolean first = true;
			for (int j = 0; j < matrix[0].length; ++j) {
				if (!first) {
					builder.append(' ');
				} else {
					first = false;
				}
				builder.append(matrix[i][j]);
			}
			builder.append('\n');
		}

		return builder.toString();
	}
}
