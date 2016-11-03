import java.util.*;

public class Chap18 {

	public static void main(String[] args) {
		String test = "this is sample text this is sparta this is madness this sparta";
		WordDistance distance = new WordDistance(test);
		System.out.println(distance.distance("this", "madness"));
		System.out.println(distance.distance("sparta", "madness"));
		System.out.println(distance.distance("sparta", "sparta"));
		System.out.println(distance.distance("this", "madness"));
	}

	/**
	 * Add two positive integers without addition operator
	 * Time: O(n): n the number of bits
	 */
	public static int add(int a, int b) {
		int result = 0;
		int mask = 1;

		boolean carry = false;

		while (a != 0 || b != 0) {
			int bitA = a & 1;
			int bitB = b & 1;

			int curBit = 0;

			if ((bitA & bitB) == 1) {
				curBit = 0;

				if (carry) {
					curBit = 1;
				}

				carry = true;
			} else if ((bitA | bitB) == 1) {
				curBit = 1;

				if (carry) {
					curBit = 0;
				}
			} else {
				curBit = 0;

				if (carry) {
					curBit = 1;
					carry = false;
				}
			}

			if (curBit == 1) {
				result |= mask;
			}

			a >>= 1;
			b >>= 1;
			mask <<= 1;
		}

		if (carry) {
			result |= mask;
		}

		return result;
	}

	/**
	 * Shuffle a deck of card
	 * Time O(n)  | n * prob
	 */
	public static void shuffle() {
		int[] deck = new int[52];
		boolean[] existed= new boolean[52];
		Random rand = new Random();

		for (int i = 0; i < 52; ++i) {
			int cand = rand.nextInt(52);
			while (existed[cand]) {
				cand = rand.nextInt(52);
			}
			existed[cand] = true;
			deck[i] = cand;
		}

		System.out.println(Arrays.toString(deck));
	}

	/**
	 * Generate m random elements from an array of n
	 */
	public static void pickFromArray(int[] data, int n) {
		if (n <= 0 || data == null || data.length == 0) {
			System.out.println("Invalid");
			return;
		}

		int[] picked = new int[n];
		Random rand = new Random();
		boolean[] flag = new boolean[data.length];

		for (int i = 0; i < n; ++i) {
			int pickNext = rand.nextInt(data.length);
			while (flag[pickNext]) {
				pickNext = rand.nextInt(data.length);
			}

			flag[pickNext] = true;
			picked[i] = data[pickNext];
		}

		System.out.println(Arrays.toString(picked));
	}

	/**
	 * Mutation distance, a variation of 18.10
	 * Time: O(n^2)
	 */
	public static int findMutationDistance(String start, String end, String[] bank) {
		/* Load data to HashSet  */
		Map<String, Integer> path = new HashMap<>();
		for (String word : bank) {
			path.put(word, -1);
		}

		//System.out.println("DEBUG:bankSet: " + dataSet);

		/* If the end sequence is not there  */
		if (!path.containsKey(end)) {
			return -1;
		}

		/* BFS */
		Queue<String> queue = new LinkedList<>();
		int counter = -1;

		queue.add(start);
		path.put(start, 0);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			//System.out.println("DEBUG:current: " + current);
			int pathSoFar = path.get(current);
			path.remove(current);

			if (current.equals(end)) {
				return pathSoFar;
			}

			List<String> next = nextWords(current, path);
			//System.out.println("DEBUG:next: " + next);
			for (String word : next) {
				path.put(word, pathSoFar + 1);
				queue.add(word);
			}
		}

		return -1;
	}

	public static List<String> nextWords(String current, Map<String, Integer> path) {
		char[] tokens = {'A', 'C', 'T', 'G'};
		List<String> result = new LinkedList<>();

		for (int i = 0; i < current.length(); ++i) {
			char[] array = current.toCharArray();
			for (char c : tokens) {
				if (c == array[i]) {
					continue;
				}
				array[i] = c;
				String str = new String(array);
				if (path.containsKey(str)) {
					result.add(str);
				}
			}
		}

		//System.out.println("DEBUG:path: " + path);
		return result;
	}

	/**
	 * Find the logest string which is the concatenation of
	 * of other Strings.
	 *
	 * Time: O(nm) n: length of data, m: length of the strings
	 */
	public static String longestConcatenation(String[] data) {
		if (data == null || data.length < 2) {
			return null;
		}
	
		String result = "";

		/* O(nlogn)  */
		Arrays.sort(data);
		/* O(n) */
		Set<String> set = new HashSet<>(Arrays.asList(data));

		/* O(nm) */
		for (int i = data.length - 1; i > 0; --i) {
			String cur = data[i];
			String pre = data[i - 1];

			if (cur.length() <=  pre.length()) {
				continue;
			}

			/* O(m) */
			String curSub = cur.substring(0, pre.length());

			/* O(m) */
			if (curSub.equals(pre)) {
				String remain = cur.substring(pre.length());
				if (set.contains(remain)) {
					return cur;
				}
			}
		}

		// Temp
		return null;
	}
}

interface Median {
	void add(int val);
	double median();
}

class MedianImp1 implements Median {

	List<Integer> data = new ArrayList<>();
	boolean sorted = false;

	/*  O(1) */
	public void add(int val) {
		if (!data.isEmpty() && val < data.get(data.size() - 1)) {
			sorted = false;
		}
		data.add(val);
	}

	/*  O(nlogn) */
	public double median() {
		if (!sorted) {
			data.sort(null);
			sorted = true;
		}

		int mid = data.size() / 2;
		
		System.out.println(data);

		if (data.size() % 2 == 0) {
			double v0 = (double) data.get(mid - 1);
			double v1 = (double) data.get(mid);

			return (v0 + v1) / 2.0d;
		} else {
			return (double) data.get(mid);
		}
	}
}

/**
 * For the shake of simplicity, let's assume that the text only contains
 * a-z and spaces as delimieters
 */
class WordDistance {

	public Map<String, List<Integer>> data;

	/**
	 * Load shit into memory
	 * Time: O(n) n is the number of tokens
	 * Space: O(n)
	 */
	public WordDistance(String text) {
		data = new HashMap<>();
		StringTokenizer token = new StringTokenizer(text);

		int tokenCounter = 0;

		while (token.hasMoreTokens()) {
			String curToken = token.nextToken();
			if (!data.containsKey(curToken)) {
				data.put(curToken, new ArrayList<>());
			}

			data.get(curToken).add(tokenCounter);
			tokenCounter += 1;
		}
		//System.out.println("DEBUB:data: " + data);
	}

	public int distance(String word0, String word1) {
		if (!data.containsKey(word0) || !data.containsKey(word1)) {
			/* No words found in the dictionary */
			return -1;
		}

		List<Integer> list0 = data.get(word0);
		List<Integer> list1 = data.get(word1);

		//System.out.println("DEBUG:list0: " + list0);
		//System.out.println("DEBUG:list1: " + list1);

		return minDif(list0, list1);
	}

	/**
	 * Time: O(m): the number of occurence of two words
	 */
	private int minDif(List<Integer> list0, List<Integer> list1) {
		int curNum = -1, preNum = -1;
		boolean curState = false, preState = false;
		int index0 = 0, index1 = 0;


		//System.out.println("DEBUG:list0: " + list0);
		//System.out.println("DEBUG:list1: " + list1);

		curState = list0.get(index0) <= list1.get(index1);

		//System.out.println("DEBUG:curState: " + curState);
		if (curState) {
			curNum = list0.get(index0);
			index0 += 1;
		} else {
			curNum = list1.get(index1);
			index1 += 1;
		}

		int result = Integer.MAX_VALUE;

		while (index0 < list0.size() || index1 < list1.size()) {
			int top0 = Integer.MAX_VALUE, top1 = Integer.MAX_VALUE;
			if (index0 < list0.size()) {
				top0 = list0.get(index0);
			}

			if (index1 < list1.size()) {
				top1 = list1.get(index1);
			}

			//System.out.println("DEBUG:top0: " + top0);
			//System.out.println("DEBUG:top1: " + top1);

			preState = curState;
			curState = top0 <= top1;

			preNum = curNum;

			if (curState) {
				curNum = list0.get(index0);
				index0 += 1;
			} else {
				curNum = list1.get(index1);
				index1 += 1;
			}

			//System.out.println("DEBUG:prestate: " + preState);
			//System.out.println("DEBUG:curState: " + curState);

			if (preState != curState) {
				//System.out.println("DEBUG:preState!=curState: ");
				int dif = Math.abs(curNum - preNum);
				result = Math.min(result, dif);
				//System.out.println("DEBUG:dif: " + dif);
				//System.out.println("DEBUG:result: " + result);
				if (result == 1) {
					break;
				}
			}
		}

		return result;
	}
}
