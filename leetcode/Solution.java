import java.util.*;

public class Solution {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		MedianFinder  med = new MedianFinder ();
		Random rand = new Random();
		for (int i = 0; i < 12; ++i) {
			int val = rand.nextInt(1000);
			System.out.println(val);

			list.add(val);
			list.sort(null);
			System.out.println(list);

			med.addNum(val);
			System.out.println("DEBUG:med: " + med.findMedian());
		}
	}

	/**
	 * #302 Power of Four
	 *
	 * Becareful of negative number
	 * Time: O(logn)
	 */
	public static boolean isPowerOfFour(int num) {
		if (num <= 0) {
			return false;
		}

		int counter = 0;
		boolean oneAlready = false;
		while (num > 0) {
			if (oneAlready) {
				return false;
			}

			if ((num & 1) == 0) {
				counter += 1;
			} else {
				oneAlready = true;
			}
			num >>= 1;
		}

		return (counter % 2 == 0);
	}

	/**
	 * Reverse String : 344
	 *
	 * Time: O(n)
	 */
	public static String reverseString(String s) {
		char[] array = s.toCharArray();
		int i = 0, j = array.length - 1;
		while (i < j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i += 1;
			j -= 1;
		}

		return new String(array);
	}
}

class MedianFinder {

	public Queue<Integer> maxQueue =
		new PriorityQueue<>(Collections.reverseOrder());

	public Queue<Integer> minQueue = new PriorityQueue<>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		maxQueue.add(num);
		minQueue.add(maxQueue.poll());
		
		if (maxQueue.size() < minQueue.size()) {
			maxQueue.add(minQueue.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (maxQueue.size() == minQueue.size()) {
			double first = (double) maxQueue.peek();
			double second = (double) minQueue.peek();

			return (first + second) / 2.0d;
		} else {
			return (double) maxQueue.peek();
		}
	}
};
