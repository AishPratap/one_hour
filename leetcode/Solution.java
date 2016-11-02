import java.util.*;

public class Solution {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(4));
	}

	/**
	 * #302 Power of Four
	 *
	 * Becareful of negative number
	 * Time: O(logn)
	 */
	public static boolean isPowerOfFour(int num) {
		if (num <= 0) {
			return false;
		}

		int counter = 0;
		boolean oneAlready = false;
		while (num > 0) {
			if (oneAlready) {
				return false;
			}

			if ((num & 1) == 0) {
				counter += 1;
			} else {
				oneAlready = true;
			}
			num >>= 1;
		}

		return (counter % 2 == 0);
	}
}
