import java.util.*;

public class Chap18 {

	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		pickFromArray(data, 4);	
		for (int i = 0; i < 15; ++i) {
			pickFromArray(data, 5);			
		}
	}

	/**
	 * Add two positive integers without addition operator
	 * Time: O(n): n the number of bits
	 */
	public static int add(int a, int b) {
		int result = 0;
		int mask = 1;

		boolean carry = false;

		while (a != 0 || b != 0) {
			int bitA = a & 1;
			int bitB = b & 1;

			int curBit = 0;

			if ((bitA & bitB) == 1) {
				curBit = 0;

				if (carry) {
					curBit = 1;
				}

				carry = true;
			} else if ((bitA | bitB) == 1) {
				curBit = 1;

				if (carry) {
					curBit = 0;
				}
			} else {
				curBit = 0;
				
				if (carry) {
					curBit = 1;
					carry = false;
				}
			}

			if (curBit == 1) {
				result |= mask;
			}

			a >>= 1;
			b >>= 1;
			mask <<= 1;
		}

		if (carry) {
			result |= mask;
		}

		return result;
	}

	/**
	 * Shuffle a deck of card
	 * Time O(n)  | n * prob
	 */
	public static void shuffle() {
		int[] deck = new int[52];
		boolean[] existed= new boolean[52];
		Random rand = new Random();

		for (int i = 0; i < 52; ++i) {
			int cand = rand.nextInt(52);
			while (existed[cand]) {
				cand = rand.nextInt(52);
			}
			existed[cand] = true;
			deck[i] = cand;
		}

		System.out.println(Arrays.toString(deck));
	}

	/**
	 * Generate m random elements from an array of n
	 */
	public static void pickFromArray(int[] data, int n) {
		if (n <= 0 || data == null || data.length == 0) {
			System.out.println("Invalid");
			return;
		}

		int[] picked = new int[n];
		Random rand = new Random();
		boolean[] flag = new boolean[data.length];

		for (int i = 0; i < n; ++i) {
			int pickNext = rand.nextInt(data.length);
			while (flag[pickNext]) {
				pickNext = rand.nextInt(data.length);
			}

			flag[pickNext] = true;
			picked[i] = data[pickNext];
		}

		System.out.println(Arrays.toString(picked));
	}
}
