import java.util.*;

public class LCS {

	public static void main(String[] args) {
		String str1 = "AWHYFCCMQX";
		String str2 = "OUDFRM";
		lcs(str1, str2);
	}

	public static void lcs(String str1, String str2) {
		int size1 = str1.length();
		int size2 = str2.length();

		int[][] matrix = new int[size2 + 1][size1 + 1];
		
		for (int i = 0; i < size2 + 1; ++i) {
			for (int j = 0; j < size1 + 1; ++j) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else {
					if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					} else {
						matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
					}
				}
			}
		}
	
		System.out.println("Table: ");

		for (int i = 0; i < size2 + 1; ++i) {
			for (int j = 0; j < size1 + 1; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Size of LCS: " + matrix[size2][size1]);

		int i = size2, j = size1;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
				sb.append(str1.charAt(j - 1));
				i -= 1;
				j -= 1;
			} else {
				if (matrix[i - 1][j] > matrix[i][j - 1]) {
					i -= 1;
				} else {
					j -= 1;
				}
			}
		}
		sb.reverse();
		System.out.println("Traceback: " + sb.toString());
	}
}
