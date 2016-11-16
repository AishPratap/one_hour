import java.util.*;

public class Chap09 {
	public static void main(String[] args) {
		dumpPara(3);
	}

	/**
	 * A staircase has n steps
	 * A child can run 1, 2, 3 steps
	 * Calculate the number of ways that he can claim
	 *	DYNAMIC PROGRAMMING
	 *	Time: O(n), Space: O(n)
	 */
	public static int stepCount(int n) {
		int[] ways = new int[n + 1];
		ways[0] = 1;

		for (int i = 1; i <= 3; ++i) {
			for (int j = i; j < n + 1; ++j) {
				ways[j] += ways[j - i];
			}
		}

		return ways[n];
	}

	/**
	 * Count the number of ways that a robot can travel
	 * Matrix: [x, y], a robot sit at [0,0],
	 * He can only go right and down
	 * How many ways that robot can go to [x,y]
	 * DYNAMIC PROGRAMMING
	 * Time: O(n^2), Space: O(n^2)
	 */
	public static long robotGo(int x, int y) {
		long[][] matrix = new long[y + 1][x + 1];
		for (int i = 0; i <= x; ++i) {
			matrix[0][i] = 1;
		}
		for (int i = 0; i <= y; ++i) {
			matrix[i][0] = 1;
		}

		for (int i = 1; i < y + 1; ++i) {
			for (int j = 1; j < x + 1; ++j) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}

		for (long[] arr : matrix) {
			for (long it : arr) {
				System.out.print(it + " ");
			}
			System.out.println();
		}

		return matrix[y][x];
	}

	/**
	 * Magic index: array: a[i] == i
	 * Distinct integers
	 * Sorted
	 * Find the magic index
	 * Time: O(logn); Space O(1)
	 */
	public static int magicIndex(int[] array) {
		return magicIndex(array, 0, array.length - 1);
	}

	public static int magicIndex(int[] array, int left, int right) {
		System.out.printf("left: %d, right: %d, mid: %d\n", left, right, (left + right) / 2);
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magicIndex(array, left, mid - 1);
		} else {
			return magicIndex(array, mid + 1, right);
		}
	}

	/**
	 * Dump the subset of one array
	 * BIT MANIPULATION
	 * Time: O(n^2) ; Space: O(1)
	 */
	public static void dumpSuperset(int[] data) {
		int total = (int) Math.pow(2, data.length);
		for (int i = 0; i < total; ++i) {
			System.out.println("Subset #" + (i + 1));
			dumpSuperset(data, i);
		}
	}
	
	public static void dumpSuperset(int[] data, int n) {
		int index = 0;
		boolean[] onBits = new boolean[data.length];
		while (n > 0) {
			if (n % 2 == 1) {
				onBits[index] = true;	
			}
			n /= 2;
			index += 1;
		}

		boolean empty = true;
		for (int i = 0; i < data.length; ++i) {
			if (onBits[i]) {
				System.out.print(data[i] + " ");
				empty = false;
			}
		}	
		if (empty) {
			System.out.println("Empty set");
		}
		System.out.println();
	}

	/**
	 * Dump a set of valid paratheses
	 * Input: 3; Ouput:  ((())), (()()), (())(), ()(()), ()()()
	 * Time: O(2^n)A
	 * Space: 
	 */
	public static void dumpPara(int n) {
		dumpPara(0, 0, n, "");
	}

	public static void dumpPara(int open, int close, int n, String str) {
		if (close > open || open > n) {
			return;
		}

		if (open == close && open == n) {
			System.out.println(str);
			return;
		}

		dumpPara(open + 1, close, n, str + "(");
		dumpPara(open, close + 1, n, str + ")");
	}

	/* Implement the paint-filling feature in paint  */
	public static void paintFill(int color, int x, int y, int[][] canvas) {
		
	}

	/**
	 * Time: O(4^n)
	 * Space: O(n)
	 * Suppose that the image is a x b so n = max9a, b)
	 */
	public static void paintFill(int x, int y, int targetColor, int newColor, int[][] canvas) {
		if (canvas[y][x]!= targetColor) {
			return;
		}

		// Fill the current pixel
		canvas[y][x] = newColor;

		// Do the same for 4 adjacent pixels
		paintFill(x + 1, y, targetColor, newColor, canvas);
		paintFill(x - 1, y, targetColor, newColor, canvas);
		paintFill(x, y + 1, targetColor, newColor, canvas);
		paintFill(x, y - 1, targetColor, newColor, canvas);
	}
}
