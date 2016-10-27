import java.util.*;

public class Chap17 {

	public static void main(String[] args) {
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
}
