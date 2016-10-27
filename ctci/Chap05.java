import java.util.*;

public class Chap05 {

	public static void main(String[] args) {
		System.out.println(bitDif(31, 14));
	}

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
}
