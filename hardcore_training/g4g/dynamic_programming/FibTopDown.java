import java.util.*;

public class FibTopDown {
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; ++i) {
			System.out.println(fibTopDown(i));
		}
	}

	public static int fibTopDown(int n) {
		if (n == 0) {
			return 0;
		}
		
		int[] lookup = new int[n + 1];
		lookup[0] = 0;
		lookup[1] = 1;
		return fibTopDown(n, lookup);
	}

	public static int fibTopDown(int n, int[] lookup) {
		if (n <= 1) {
			return lookup[n];
		}

		if (lookup[n - 1] == 0) {
			lookup[n - 1] = fibTopDown(n - 1, lookup);
		}
		if (lookup[n - 2] == 0) {
			lookup[n - 2] = fibTopDown(n - 2, lookup);
		}
		
		lookup[n] = lookup[n - 1] + lookup[n - 2];
		return lookup[n];
	}
}
