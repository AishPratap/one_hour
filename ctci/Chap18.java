import java.util.*;

public class Chap18 {

	public static void main(String[] args) {
		shuffle();
		shuffle();
		shuffle();
		shuffle();
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
}
