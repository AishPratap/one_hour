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
	 */
	public static int drone(int[] height) {
		int max = height[0];
		for (int i = 0; i < height.length; ++i) {
			max = Math.max(max, height[i]);
		}

		return max - height[0];
	}
}
