import java.util.*;

public class FibBottomUp {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			System.out.println(fibBottomUp(i));
		}
	}

	public static int fibBottomUp(int n) {
		if (n <= 1) {
			return n;
		}

		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; ++i) {
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}
}

