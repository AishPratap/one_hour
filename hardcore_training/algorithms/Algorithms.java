import java.util.*;
import java.io.*;

public class Algorithms {

	public static void main(String[] args) {
		int[] data = {15, 27, 14, 38, 26, 55, 46, 65, 85};
		int result = LIS(data);
		System.out.println(result);
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
}
