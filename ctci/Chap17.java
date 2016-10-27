import java.util.*;

public class Chap17 {

	public static void main(String[] args) {
		int[] data = {490, 99};
		swap0(data);
		System.out.println(Arrays.toString(data));
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
}
