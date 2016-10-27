import java.util.*;

public class Chap17 {

	public static void main(String[] args) {
		int n = 25;
		System.out.println(trailingZero(n));
		System.out.println(naiveTrailingZero(n));
	}

	/**
	 * Swap two numbers in place
	 * Time O(1), Space: O(1)
	 */
	public static void swap(double[] data) {
		data[0] -= data[1];
		data[1] += data[0];
		data[0] = data[1] - data[0];
	}

	public static void swap0(int[] data) {
		data[0] ^= data[1];
		data[1] ^= data[0];
		data[0] ^= data[1];
	}

	/**
	 * Decide who won the game of tic tac toe
	 * Assume that the board 3x3 is fixed
	 * 1: O, X: -1: Nope: 0
	 * Time: O(1)
	 */
	public static int ticTacToe(int[][] board) {
		for (int i = 0; i < 3; ++i) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				if (board[i][0] == 1) {
					return 1;
				} else {
					return -1;
				}
			}

			if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				if (board[0][i] == 1) {
					return 1;
				} else {
					return -1;
				}
			}
		}

		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if (board[1][1] == 1) {
				return 1;
			} else {
				return -1;
			}
		}

		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if (board[1][1] == 1) {
				return 1;
			} else {
				return -1;
			}
		}

		return 0;
	}

	/**
	 * Calculate the number of trailing zero of n factorial
	 */
	public static int trailingZero(int n) {
		if (n < 5) {
			return 0;
		}

		long result = 24;
		for (int i = 5; i <= n; ++i) {
			result *= i;
			result = truncate(result);
		}

		return trailing(result);
	}

	public static int naiveTrailingZero(int n) {
		long result = 1;
		for (int i = 2; i <= n; ++i) {
			result *= i;
		}

		return trailing(result);
	}

	public static long truncate(long n) {
		int level = 0;
		long digit = 0;
		while (n > 0) {
			digit = n % 10;
			n /= 10;
			if (digit != 0) {
				break;
			}
			level += 1;
		}
		long result = (long) Math.pow(10, level) * digit;
		return result;
	}

	public static int trailing(long n) {
		int result = 0;
		while (n > 0) {
			if (n % 10 == 0) {
				result += 1;
			} else {
				break;
			}
			n /= 10;
		}

		return result;
	}
}
