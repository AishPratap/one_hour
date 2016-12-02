import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		File file = new File("input");
		Scanner scan = new Scanner(file);
		int rows = scan.nextInt();
		int cols = scan.nextInt();


		int[][] data = new int[rows][cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				data[i][j] = scan.nextInt();
			}
		}
	
		for (int[] row : data) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}

		System.out.println();
		printSprial(data);
	}

	/**
	 * https://www.pramp.com/question/VKdqbrq6B1S5XAyGAOn4
	 * Time: O(n)
	 * Space: O(1)
	 */
	public static void wordReverse(char[] str) {
		reverse(str, 0, str.length - 1);
		int i = 0;
		while (i < str.length) {
			int j = i + 1;
			while (j < str.length && str[j] != ' ') {
				j += 1;
			}
			reverse(str, i, j - 1);
			i = j + 1;
		}
	}

	public static void reverse(char[] str, int left, int right) {
		char temp;
		while (left < right) {
			temp = str[left];
			str[left] = str[right];
			str[right] = temp;

			left += 1;
			right -= 1;
		}
	}

	/**
	 * https://www.pramp.com/question/BrLMj8M2dVUoY95A9x3X
	 * We only care about the height
	 * Time: O(n)
	 * Space O(1)
	 */
	public static int drone(int[] height) {
		int max = height[0];
		for (int i = 0; i < height.length; ++i) {
			max = Math.max(max, height[i]);
		}

		return max - height[0];
	}

	/**
	 * https://www.pramp.com/question/3QnxW6xoPLTNl5jX5Lg1
	 * Time: O(nlogn + mlogm)
	 * Space: O(1)
	 */
	public static int[] timePlanner(int dur, int[][] timeA,
			int[][] timeB) {
		Arrays.sort(timeA, (int[] a, int[] b) -> {
			return a[0] - b[0];
		});

		Arrays.sort(timeB, (int[] a, int[] b) -> {
			return a[0] - b[0];
		});

		int i = 0, j = 0;
		while (i < timeA.length && j < timeB.length) {
			int start = Math.max(timeA[i][0], timeB[j][0]);
			int end = Math.min(timeA[i][1], timeB[j][1]);

			if (start + dur <= end) {
				return new int[] {start, start + dur};
			}

			if (timeA[i][1] < timeB[j][1]) {
				i += 1;
			} else {
				j += 1;
			}
		}

		return null;
	}

	/**
	 * https://www.pramp.com/question/EmYgnOgVd4IElnjAnQqn
	 *       p0u 
	 *       |
	 *       |
	 *       p0----*----p1
	 *
	 *       Time: O(4^n)
	 *       Space O(n)
	 *
	 *       n is the depth
	 */
	public static void drawHTree(double x, double y, double length, int depth) {
		if (depth <= 0) {
			return;
		}

		double xp0 = x - length / 2;
		double yp0 = y;

		double xp1 = x + length / 2;
		double yp1 = y;

		double xp0u = xp0;
		double yp0u = yp0 + length / 2;

		double xp0d = xp0;
		double yp0d = yp0 - length / 2;

		double xp1u = xp1;
		double yp1u = yp1 + length / 2;

		double xp1d = xp1;
		double yp1d = yp1 - length / 2;

		drawLine(xp0, yp0, xp1, yp1);
		drawLine(xp0u, yp0u, xp0d, yp0d);
		drawLine(xp1u, yp1u, xp1d, yp1d);

		double newLength = length / Math.sqrt(2);

		drawHTree(xp0u, yp0u, newLength, depth - 1);
		drawHTree(xp0d, yp0d, newLength, depth - 1);
		drawHTree(xp1u, yp1u, newLength, depth - 1);
		drawHTree(xp1d, yp1d, newLength, depth - 1);
	}

	public static void drawLine(double x0, double y0,
			double x1, double y1) {
		// Dummy function
	}

	/**
	 * https://www.pramp.com/question/pK6A4GA5YES09qKmqG33
	 * Time: Best and average: O(logn)
	 * Time: Worst: O(n)
	 * Space: O(1)
	 */
	public Node largestSmaller(Node root, int val) {
		Node result = null;

		while (root != null) {
			if (root.val < val) {
				result = root;
				root = root.right;
			} else {
				root = root.left;
			}
		}

		return result;
	}

	public static void flatMap(Map<String, Object> input) {
		Map<String, String> output = new HashMap<>();
		flatMap(input, output, "");
	}

	/**
	 * Flat a map
	 * Time: O(n)
	 * Space: O(n)
	 * Need to see the analysis again
	 */
	public static void flatMap(Map<String, Object> input, 
			Map<String, String> output, String preKey) {
		for (Map.Entry<String, Object> entry : input.entrySet()) {
			String key = "";
			if (preKey.isEmpty()) {
				key = entry.getKey();
			} else {
				key = preKey + "." + entry.getKey();
			}

			if (entry.getValue() instanceof String) {
				output.put(key, (String) entry.getValue());
			} else {
				flatMap((Map<String, Object>) entry.getValue(),
							output, key);
			}
		}
	}

	/**
	 * Given a string and an array which contains unique characters
	 * Return the smallest substring which contains all of those char
	 * 
	 * Time: O(n * m)
	 * Space: O(m)
	 */

	public static String smallestSubstring(String str, char[] arr) {
		int i = -1, j = -1;
		int resultI = -1, resultJ = -1;
		int min = Integer.MAX_VALUE;

		Map<Character, Integer> map = new HashMap<>();
		for (char c : arr) {
			map.put(c, 0);
		}

		while (j + 1 < str.length()) {
			j += 1;
			char c = str.charAt(j);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}

			while (isOK(map)) {
			i += 1;
				if (j - i < min) {
					min = j - i;
					resultI = i;
					resultJ = j;
				}

				char d = str.charAt(i);
				if (map.containsKey(d)) {
					map.put(d, map.get(d) - 1);
				}
			}
		}
		
		return str.substring(resultI, resultJ + 1);
	}

	public static boolean isOK(Map<Character, Integer> map) {
		for (Map.Entry<Character, Integer> it : map.entrySet()) {
			if (it.getValue() <= 0) {
				return false;
			}	
		}

		return true;
	}

	public static void debug(String msg, String val) {
		System.out.println(msg + ": " + val);
	}

	/**
	 * Print a matrix in sprial order
	 */

	/*
	1 2 3 4 5 6 7
	8 9 0 1 2 3 4
	5 6 7 8 9 0 1
	2 3 4 5 6 7 8
	9 0 1 2 3 4 5

	 * */
	public static void printSprial(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int layers = (Math.min(rows, cols) + 1) / 2;

		for (int i = 0; i < layers; ++i) {
			peelOnion(matrix, i);
		}

		System.out.println();
	}

	public static void peelOnion(int[][] matrix, int layer) {
		int left = layer;
		int right = matrix[0].length - layer - 1;

		int up = layer;
		int down = matrix.length - layer - 1;

		for (int i = left; i < right; ++i) {
			System.out.print(matrix[up][i] + " ");
		}

		for (int i = up; i < down; ++i) {
			System.out.print(matrix[i][right] + " ");
		}

		for (int i = right; i > left; --i) {
			System.out.print(matrix[down][i] + " ");
		}

		for (int i = down; i > up; --i) {
			System.out.print(matrix[i][left] + " ");
		}
	}
}

class Node {
	int val;
	Node left, right;
}
