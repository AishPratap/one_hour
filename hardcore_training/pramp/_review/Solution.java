import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		String test = "practice makes perfect";
		char[] data = test.toCharArray();
		wordReverse(data);

		System.out.println(Arrays.toString(data));
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
}
