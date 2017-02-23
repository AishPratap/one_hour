import java.util.*;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		System.out.println(lcs(str1, str2));
	}

	public static int lcs(String str1, String str2) {
		int size1 = str1.length();
		int size2 = str2.length();

		int[][] f = new int[size2 + 1][size1 + 1];

		for (int i = 0; i < size2 + 1; ++i) {
			for (int j = 0; j < size1 + 1; ++j) {
				if (i == 0 || j == 0) {
					f[i][j] = 0;
				} else if (str1.charAt(j - 1) 
					== str2.charAt(i - 1)) {
					f[i][j] = 1 + f[i - 1][j - 1];
				} else {
					f[i][j] = Math.max(f[i - 1][j],
							   f[i][j - 1]);
				}
			}
		}

		return f[size2][size1];
	}
}

