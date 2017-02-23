import java.util.*;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] data = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis(data));
	}

	public static int lis(int[] data) {
		int n = data.length;
		int[] f = new int[n];
		f[n - 1] = 1;
		int ret = 1;
		for (int i = n - 2; i >= 0; --i) {
			f[i] = 1;
			for (int j = i + 1; j < n; ++j) {
				if (data[i] < data[j]) {
					f[i] += f[j];
					break;
				}
			}
			ret = Math.max(ret, f[i]);
		}

		System.out.println("debug");
		for (int i = 0; i < n; ++i) {
			System.out.printf("key = %d, value = %d\n", data[i], f[i]);
		}

		return ret;
	}
}

