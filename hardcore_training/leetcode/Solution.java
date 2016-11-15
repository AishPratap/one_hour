import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String str0 = "foobar";
		String str1 = "foo";

		System.out.println(minDistance(str0, str1));
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

	public static int missingNumber(int[] nums) {
		int size = nums.length;
		long sum = (size * (size + 1)) / 2;

		for (int it : nums) {
			sum -= it;
		}

		return (int) sum;
	}

	/**
	 * Constrait: O(n) runtime
	 */
	public static int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int it : nums) {
			map.put(it, 0);
		}

		for (int it : nums) {
			if (map.get(it) == 0) {
				mark(it, map);
			}
		}

		int max = 1;

		for (Map.Entry<Integer, Integer> it : map.entrySet()) {
			max = Math.max(max, it.getValue());
		}

		return max;
	}

	public static void mark(int num, Map<Integer, Integer> map) {
		int next = num + 1;
		if (!map.containsKey(next)) {
			map.put(num, 1);
		} else if (map.get(next) > 0) {
			map.put(num, map.get(next) + 1);
		} else {
			mark(next, map);
			map.put(num, map.get(next) + 1);
		}
	}

	public static int findDuplicate(int[] nums) {
		int oneStep = nums[0];
		int twoStep = nums[nums[0]];

		while (oneStep != twoStep) {
			System.out.println("DEBUG: oneStep: " + oneStep);
			System.out.println("DEBUG: twoStep: " + twoStep);

			oneStep = nums[oneStep];
			twoStep = nums[nums[twoStep]];
		}

		return oneStep;
	}

	/**
	 * Return true if ransomNote can be constructed by magazine
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> ransomMap =
			new HashMap<>();
		Map<Character, Integer> magazineMap =
			new HashMap<>();

		for (int i = 0; i < ransomNote.length(); ++i) {
			char cur = ransomNote.charAt(i);
			if (!ransomMap.containsKey(cur)) {
				ransomMap.put(cur, 0);
			}

			ransomMap.put(cur, ransomMap.get(cur) + 1);
		}

		for (int i = 0; i < magazine.length(); ++i) {
			char cur = magazine.charAt(i);
			if (!magazineMap.containsKey(cur)) {
				magazineMap.put(cur, 0);
			}

			magazineMap.put(cur, magazineMap.get(cur) + 1);
		}

		for (Map.Entry<Character, Integer> entry : 
				ransomMap.entrySet()) {
			char cur = entry.getKey();
			int ransomCurOcc = entry.getValue();

			//System.out.println("DEBUG:cur: " + cur);

			if (!magazineMap.containsKey(cur)) {
				return false;
			}

			int magazineCurOcc = magazineMap.get(cur);

			if (ransomCurOcc > magazineCurOcc) {
				return false;
			}
		}

		return true;
	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] matrix = new int[len2 + 1][len1 + 1];

		for (int i = 0; i <= len2; ++i) {
			for (int j = 0; j <= len1; ++j) {
				if (i == 0) {
					matrix[i][j] = j;
					continue;
				}

				if (j == 0) {
					matrix[i][j] = i;
					continue;
				}

				int val0 = matrix[i- 1][j - 1];
				int val1 = matrix[i - 1][j] + 1;
				int val2 = matrix[i][j - 1] + 1;

				char char1 = word1.charAt(j - 1);
				char char2 = word2.charAt(i - 1);	

				if (char1 != char2) {
					val0 += 1;
				}

				matrix[i][j] =
					Math.min(val0, Math.min(val1, val2));
			}
		}

		return matrix[len2][len1];
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

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }

	public String toString() {
		StringBuilder result = new StringBuilder();

		result
			.append('[')
			.append(start)
			.append(", ")
			.append(end)
			.append(']');

		return result.toString();
	}
}

class SummaryRanges {

	public TreeSet<Interval> set;

	/** Initialize your data structure here. */
	public SummaryRanges() {
		set = new TreeSet<>(new Comparator<Interval>() {
			public int compare(Interval obj0, Interval obj1) {
				return obj0.start - obj1.start;
			}
		});
	}

	public void addNum(int val) {
		Interval curInterval = new Interval(val, val);

		Interval ceiling = set.higher(curInterval);
		Interval floor = set.floor(curInterval);

		//System.out.println("DEBUG:floor: " + floor);
		//System.out.println("DEBUG:ceiling: " + ceiling);

		if (ceiling != null) {
			if (val == ceiling.start - 1) {
				curInterval.end = ceiling.end;
				set.remove(ceiling);
			}
		}

		if (floor != null) {
			if (floor.start == val || val <= floor.end) {
				return;
			}

			if (val == floor.end + 1) {
				curInterval.start = floor.start;
				set.remove(floor);
			}
		}

		set.add(curInterval);
	}

	public List<Interval> getIntervals() {
		return new ArrayList<>(set);
	}
}

class RandomizedSet {

	public Set<Integer> set;
	public Random rand;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		set = new HashSet<>();
		rand = new Random();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		return set.add(val);
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		return set.remove(val);
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int step = rand.nextInt(set.size());
		Iterator<Integer> iterator = set.iterator();
		for (int i = 0; i < step; ++i) {
			iterator.next();
		}

		return iterator.next();
	}
}