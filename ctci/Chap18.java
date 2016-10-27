import java.util.*;

public class Chap18 {

	public static void main(String[] args) {
		System.out.println(add(3, 5));
	}

	public static int add(int a, int b) {
		boolean carry = false;
		int result = 0;

		while (a > 0 || b > 0) {
			int bitA = a & 1;
			int bitB = b & 1;

			System.out.printf("Bit A: %d, Bit B: %d\n", bitA, bitB);

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

			a >>= 1;
			b >>= 1;

			System.out.println("DEBUG:curBit: " + curBit);
			result |= curBit;

			result <<= 1;
		}

		
		return result;
	}
}
