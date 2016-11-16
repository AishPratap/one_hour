import java.util.*;

public class Chap11 {

	public static void main(String[] args) {
		String[] data = {"at", "ball", "", "", "", "ball", "", "car", "", "", "dad", "", ""};
		System.out.println(binSearchEmpty("ball", data));
	}

	/**
	 * Merge two arrays, of course, sorted array
	 * O(n): n is the length of the larger array
	 */
	public static void merge(int[] a, int sizeA, int[] b) {
		if (a == null || b == null || b.length == 0) {
			return;
		}

		if (sizeA == 0) {
			for (int i= 0; i < b.length; ++i) {
				a[i] = b[i];
			}
			return;
		}

		int lastIndexA = sizeA - 1;
		int lastIndexB = b.length - 1;
		int lastIndex = a.length - 1;

		while (lastIndex >= 0) {
			if (lastIndexA == -1) {
				a[lastIndex--] = b[lastIndexB--];
			} else if (lastIndexB == -1) {
				a[lastIndex--] = a[lastIndexA--];
			} else if (a[lastIndexA] >= b[lastIndexB]) {
				a[lastIndex--] = a[lastIndexA--];
			} else {
				a[lastIndex--] = b[lastIndexB--];
			}
		}
	}

	/**
	 * Given a sorted and rotated array, find index of a given val
	 * Time: O(n) in the first time, O(logn) if we save the boundary
	 */
	public static int rotatedSearch(int[] array, int val) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int border  = -1;

		for (int i = 0; i < array.length - 1; ++i) {
			if (array[i] > array[i + 1]) {
				border  = i;
				break;
			}
		}

		if (border  == -1) {
			// No rotation
			return Arrays.binarySearch(array, val);	
		}

		if (val <= array[array.length - 1]) {
			return Arrays.binarySearch(array, border + 1,
					array.length, val);
		} else {
			return Arrays.binarySearch(array, 0, border + 1, val);
		}
	}

	/**
	 * Circus
	 * Greedy, O(nlogn)
	 */
	public static void sortCircus(Person[] people) {
		Arrays.sort(people, (Person a, Person b) -> {
			return a.weight - b.weight;
		});

		List<Person> weightList = new ArrayList<>();
		for (Person it : people) {
			if (
					weightList.isEmpty() || 
					weightList.get(weightList.size() - 1).isOk2Stack(it)
			   ) {
				weightList.add(it);
			   }
		}

		Arrays.sort(people, (Person a, Person b) -> {
			return a.height - b.height;
		});

		List<Person> heightList = new ArrayList<>();
		for (Person it : people) {
			if (
					heightList.isEmpty() ||
					heightList.get(heightList.size() - 1).isOk2Stack(it)
			   ) {
				heightList.add(it);
			   }
		}

		System.out.println(weightList);
		System.out.println(heightList);
	}

	public static int binSearchEmpty(String key, String[] data) {
		return binSearchEmpty(0, data.length - 1, key, data);
	}

	public static int binSearchEmpty(int left, int right,
			String key, String[] data) {

		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;
		int goLeft = mid;
		int goRight = mid;

		while (goLeft >= left || goRight <= right) {
			if (goRight <= right && !data[goRight].isEmpty()) {
				mid = goRight;
				break;
			}

			if (goLeft >= left && !data[goLeft].isEmpty()) {
				mid = goLeft;
				break;
			}
			goLeft -= 1;
			goRight += 1;
		}

		if (data[mid].isEmpty()) {
			return -1;
		}

		if (data[mid] == key) {
			return mid;
		}

		else if (data[mid].isEmpty()) {
		}

		if (key.compareTo(data[mid]) < 0) {
			return binSearchEmpty(left, mid - 1, key, data);
		} else {
			return binSearchEmpty(mid + 1, right, key, data);
		}
	}
}

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String str0, String str1) {
		String sorted0 = stringSort(str0);
		String sorted1 = stringSort(str1);

		return sorted0.compareTo(sorted1);
	}

	private String stringSort(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}

class Person {
	int weight;
	int height;

	public Person(int weight, int height) {
		this.weight = weight;
		this. height = height;
	}

	public String toString() {
		return "(" + weight + ", " + height + ")";
	}

	public boolean isOk2Stack(Person above) {
		return this.weight < above.weight && this.height < above.height;
	}
}
