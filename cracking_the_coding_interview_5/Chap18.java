import java.util.*;

public class Chap18 {

	public static void main(String[] args) {
		Median med = new MedianImp1();
		Random rand = new Random();

		for (int i = 0; i < 15; ++i) {
			med.add(rand.nextInt(1000));
			System.out.println(med.median());
		}
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
