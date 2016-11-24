import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] data = {4,5,6,7,0,1,2};
		System.out.println(search(data, 69));
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

	/**
	 * Given a list of unique words, find all pairs of distinct
	 * indices (i, j) in the given list,
	 * so that the concatenation of the two words
	 */
	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < words.length; ++i) {
			for (int j = 0; j < words.length; ++j) {
				if (i == j) {
					continue;
				}

				if (isPalindrome(words[i], words[j])) {
					List<Integer> pair =
						new ArrayList<>();
					pair.add(i);
					pair.add(j);

					result.add(pair);
				}
			}
		}

		return result;
	}

	public static boolean isPalindrome(String a, String b) {
		String concat = a + b;
		int i = 0, j = concat.length() - 1;

		while (i < j) {
			if (concat.charAt(i) != concat.charAt(j)) {
				return false;
			}

			i += 1;
			j -= 1;
		}

		return true;
	}

	/**
	 * Suppose a sorted array is rotated at some pivot
	 * unknown to you beforehand.
	 *
	 * Time: O(logn)
	 * Space: O(1)
	 */
	public static int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return findMin(nums, 0, nums.length - 1);
	}

	public static int findMin(int[] nums, int left, int right) {
		int mid = (left + right) / 2;
		if (nums[left] > nums[mid]) {
			return findMin(nums, left, mid);
		} else if (nums[mid + 1] > nums[right]) {
			return findMin(nums, mid + 1, right);
		} else {
			return nums[left] < nums[mid + 1] ? left : mid + 1;
		}
	}

	/**
	 * Suppose a sorted array is rotated at some pivot
	 * unknown to you beforehand.
	 *
	 * Time O(logn)
	 * Space O(1)
	 */
	public static int search(int[] nums, int target) {
		int pivot = findMin(nums);
		if (pivot == 0) {
			return binarySearch(nums, target, 0, nums.length - 1);
		}

		return Math.max(binarySearch(nums, target, 0, pivot - 1),
				binarySearch(nums, target, pivot, nums.length - 1));
	}	

	public static int binarySearch(int[] data, int key,
			int left, int right) {

		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;

		if (key == data[mid]) {
			return mid;
		} else if (key < data[mid]){
			return binarySearch(data, key, left, mid - 1);
		} else {
			return binarySearch(data, key, mid + 1, right);
		}
	}

	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		Arrays.sort(envelopes, (int[] a, int[] b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}

			return a[1] - b[1];
		});

		int maxSoFar = 1;
		int[] len = new int[envelopes.length];

		len[0] = 1;

		for (int i = 1; i < envelopes.length; ++i) {
			int max = 0;

			for (int j = 0; j < i; ++j) {
				if (envelopes[j][1] < envelopes[i][1] 
						&& envelopes[j][0] < envelopes[i][0]) {
					max = Math.max(max, len[j]);
						}
			}

			max += 1;
			len[i] = max;
			maxSoFar = Math.max(max, maxSoFar);
		}

		return maxSoFar;
	}

	/**
	 * Given an unsorted array of integers, find the length of
	 * longest increasing subsequence
	 */
	public static int lengthOfLIS(int[] data) {
		if (data == null || data.length == 0) {
			return 0;
		}

		int[] length = new int[data.length];
		length[0] = 1;

		int maxSoFar = 1;

		for (int i = 1; i < data.length; ++i) {
			int max = 0;
			for (int j = 0; j < i; ++j) {
				if (data[j] < data[i]) {
					max = Math.max(max, length[j]);
				}
			}

			length[i] = max + 1;
			maxSoFar = Math.max(length[i], maxSoFar);
		}
		return maxSoFar;
	}

	/**
	 * Write a program to check whether a given number is an ugly number
	 */
	public static boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}

		if (num == 1) {
			return true;
		}

		int[] div = {2, 3, 5};
		for (int it : div) {
			while (num % it == 0) {
				num /= it;
			}
		}

		return num == 1;
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
