import java.util.*;
import java.io.*;

public class Algorithms {

	public static void main(String[] args) {
		int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(kadane(data));
	}

	/**
	 * Find the length of the longest common subsequence
	 * Category: DP
	 * Time: O(n^2)
	 * Space O(n)
	 */
	public static int LIS(int[] data) {
		if (data == null || data.length == 0) {
			return 0;
		}

		int[] length = new int[data.length];
		length[0] = 1;

		int maxSoFar = 1;

		for (int i = 1; i < data.length; ++i) {
			int max = 0;
			for (int j = 0; j < i; ++j) {
				if (data[j] < data[i]) {
					max = Math.max(max, length[j]);
				}
			}

			length[i] = max + 1;
			maxSoFar = Math.max(length[i], maxSoFar);
		}
		return maxSoFar;
	}

	/**
	 * Kadane's algorithm to find the largest subarray problem
	 * Time: O(n)
	 * Space: O(1)
	 */
	public static int kadane(int[] data) {
		int max = data[0];
		int maxSoFar = data[0];

		for (int i = 1; i < data.length; ++i) {
			int it = data[i];
			max = Math.max(max + it, it);
			maxSoFar = Math.max(maxSoFar, max);
		}

		return maxSoFar;
	}
}
