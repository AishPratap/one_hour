import java.util.*;

public class Chap17 {

	public static void main(String[] args) {
		int[] data = {4,1,2,3,4,5,6,7,8,9};
		pairSum(data, 10);
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

	/**
	 * Return the maximum number without if-else and comparison oprerations
	 */
	public static int tryHardMax(int a, int b) {
		return -1;
	}

	/**
	 * Find the minimum range to sort
	 * Valid argument guarantee
	 * Time: O(n)
	 */
	public static void minimumRange(int[] data) {
		if (data == null || data.length <= 1) {
			System.out.println("No need to sort!");
			return;
		}

		int left= 0, right = data.length - 1;
		while (true) {
			if (left >= data.length - 1 || data[left] > data[left + 1]) {
				break;
			}
			left += 1;
		}

		while (true) {
			if (right <= 0 || data[right] < data[right - 1]) {
				break;
			}
			right -= 1;
		}

		if (left >= right) {
			// Already a sorted array
			System.out.println("The array is already sorted");
			return;
		}

		// Find max and min for the interval
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = left; i <= right; ++i) {
			max = Math.max(max, data[i]);
			min = Math.min(min, data[i]);
		}

		// Expend to the left
		while (true) {
			if (left <= 0) {
				break;
			}

			if (min >= data[left - 1]) {
				break;
			}
			
			left -= 1;
			if (left >= 0) {
				min = Math.min(min, data[left]);
			}
		}

		// Expand to the right
		while (true) {
			if (right >= data.length - 1) {
				break;
			}

			if (max <= data[right + 1]) {
				break;
			}
			right += 1;
			if (right <= data.length - 1) {
				max = Math.max(max, data[right]);
			}
		}	

		System.out.println("Sort from " + left + " to " + right);
	}

	/**
	 * Kadane's Algorithm
	 * O(n)
	 */
	public static int largestContiuousSum(int[] data) {
		if (data == null || data.length == 0) {
			return 0;
		}

		if (data.length == 1) {
			return data[0];
		}

		int maxSoFar = data[0];
		int max = maxSoFar;

		for (int i = 1; i < data.length; ++i) {
			max = Math.max(max + data[i], data[i]);
			maxSoFar = Math.max(maxSoFar, max);
		}

		return maxSoFar;	
	}

	/**
	 * Given rand7 implement rand5
	 */
	public static int rand5() {
		Random rand = new Random();
		return rand.nextInt(5);
	}

	public static int rand7() {
		return rand5() + rand5() / 2;
	}

	/**
	 * Find all pairs in an array that sum to a specific value
	 * In case of duplication: display once
	 * Time: O(n)
	 */
	public static void pairSum(int[] data, int sum) {
		Set<Integer> dataSet = new HashSet<>();
		Set<Integer> paired = new HashSet<>();

		for (int it : data) {
			dataSet.add(it);
		}

		for (int it : data) {
			if (paired.contains(it)) {
				continue;
			}

			int wanted = sum - it;
			if (dataSet.contains(wanted)) {
				System.out.println(it + " and " + wanted);
				paired.add(it);
				paired.add(wanted);
			}
		}
	}
}
