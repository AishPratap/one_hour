import java.util.*;
import java.io.*;

public class Array {

	public static void main(String[] args) {
		int[] data = {0};
		int result = firstMissingPositive(data);
		System.out.println(result);
	}

	/**
	 *  Given an unsorted integer array,
	 *  find the first missing positive integer.
	 *
	 *  Time: O(n)
	 *  Space: O(1)
	 *
	 *  The only trick here to use a bucketsort-like algorithm to put
	 *  the elements at the right indices
	 */
	public static int firstMissingPositive(int[] data) {
		for (int i = 0; i < data.length; ++i) {
			while (data[i] != i + 1) {
				if (
					data[i] <= 0 ||
					data[i] >= data.length || 
					data[i] == data[data[i] - 1]
				) {

					/* Out of scope or duplication or 
					 * it doensn't need to change */
					break;
				}

				int temp = data[i];
				data[i] = data[data[i] - 1];
				data[temp - 1] = temp;
			}
		}

		for (int i = 0; i < data.length; ++i) {
			if (data[i] != i + 1) {
				return i += 1;
			}
		}

		return data.length + 1;
	}
}
