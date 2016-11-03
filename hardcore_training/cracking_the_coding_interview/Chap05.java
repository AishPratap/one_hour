import java.util.*;

public class Chap05 {

	public static void main(String[] args) {
		System.out.println(bitDif(15, 14));
	}

	/**
	 * Returns the number of bit to make a become b
	 */
	public static int bitDif(int a, int b) {
		int xor = a ^ b;
		int counter = 0;
		while (xor > 0) {
			if ((xor & 1) == 1) {
				counter += 1;
			}
			xor >>= 1;
		}

		return counter;
	}

	/**
	 * Swap bit 0, 1; 2, 3; 4,5...
	 * With as few instructions as possible
	 */
	public static int swapBit(int n) {
	}
}
