import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		int[] h = {10, 0, 6, 15, 8};
		System.out.println(drone(h));		
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
}
