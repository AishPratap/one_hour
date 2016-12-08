import java.util.*;
import java.io.*;

public class Array {

	public static void main(String[] args) {
	}

	/**
	 *  41. First Missing Positive
	 *
	 *  Given an unsorted integer array,
	 *  find the first missing positive integer.
	 *
	 *  Time: O(n)
	 *  Space: O(1)
	 *
	 *  The only trick here to use a bucketsort-like algorithm to put
	 *  the elements at the right indices
	 */
	public static int firstMissingPositive(int[] data) {
		for (int i = 0; i < data.length; ++i) {
			while (data[i] != i + 1) {
				if (
					data[i] <= 0 ||
					data[i] >= data.length || 
					data[i] == data[data[i] - 1]
				) {

					/* Out of scope or duplication or 
					 * it doensn't need to change */
					break;
				}

				int temp = data[i];
				data[i] = data[data[i] - 1];
				data[temp - 1] = temp;
			}
		}

		for (int i = 0; i < data.length; ++i) {
			if (data[i] != i + 1) {
				return i += 1;
			}
		}

		return data.length + 1;
	}

	/**
	 *  56. Merge Intervals 
	 *  Given a collection of intervals, merge all overlapping intervals.
	 *  Time: O(nlogn)
	 *  Space: O(n)
	 */
	public static List<Interval> merge(List<Interval> intervals) {
		// Handle empty list
		if (intervals == null || intervals.isEmpty()) {
			return new ArrayList<Interval>();
		}	

		TreeSet<Interval> set = new TreeSet<>((Interval a, Interval b) -> {
			return a.start - b.start;
		});

		for (Interval it : intervals) {
			Interval ceiling = set.ceiling(it);

			while (ceiling != null && isOverlapped(it, ceiling)) {
				it.start = Math.min(it.start, ceiling.start);
				it.end = Math.max(it.end, ceiling.end);
				set.remove(ceiling);
				ceiling = set.ceiling(it);
			}
			
			Interval floor = set.floor(it);
			while (floor != null && isOverlapped(it, floor)) {
				it.start = Math.min(it.start, floor.start);
				it.end = Math.max(it.end, floor.end);
				set.remove(floor);

				floor = set.floor(it);
			}

			set.add(it);
		}

		return new ArrayList<>(set);
	}

	/**
	 * Another better approach
	 * Surprisingly, this solution does take more time than
	 * the previous one
	 */
	public static List<Interval> merge2(List<Interval> intervals) {
		intervals.sort((Interval a, Interval b) -> {
			return a.start - b.start;
		});

		Stack<Interval> result = new Stack<>();

		for (Interval it : intervals) {
			if (result.isEmpty()) {
				result.push(it);
				continue;
			}
			
			if (isOverlapped(result.peek(), it)) {
				Interval top = result.pop();
				it.start = Math.min(top.start, it.start);
				it.end = Math.max(top.end, it.end);
			}

			result.add(it);
		}

		return new ArrayList<>(result);
	}	

	public static boolean isOverlapped(Interval a, Interval b) {
		// a.end >= b.start and a.end <= b.end or other wayA
		return (a.end >= b.start && a.end <= b.end) ||
			(b.end >= a.start && b.end <= a.end);
	}

	/**
	 *  153. Find Minimum in Rotated Sorted Array 
	 *  Suppose a sorted array is rotated at some
	 *  pivot unknown to you beforehand.
	 *  Time: O(logn)
	 *  Space: O(1)
	 */
	public static int findMin(int[] nums) {
		if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
			return nums[0];
		}

		return findMin(nums, 0, nums.length - 1);
	}

	public static int findMin(int[] nums, int start, int end) {
		if (end - start == 1) {
			return Math.min(nums[start], nums[end]);
		}

		int mid = (start + end) / 2;
		if (nums[start] > nums[mid]) {
			return findMin(nums, start, mid);
		} else {
			return findMin(nums, mid, end);
		}
	}

	/**
	 * 57. Insert Interval  
	 * Given a set of non-overlapping intervals,
	 * insert a new interval into the intervals (merge if necessary).
	 * You may assume that the intervals were
	 * initially sorted according to their start times.
	 *
	 * Time O(n)
	 * Space O(n)
	 */
	public static List<Interval> insert(List<Interval> data, Interval insert) {
		Stack<Interval>	stack = new Stack<>();

		boolean inserted = false;
		int index = 0;

		while (index < data.size() || !inserted) {
			if (inserted) {
				addInterval(data.get(index), stack);
				index += 1;
			} else if (index >= data.size()) {
				addInterval(insert, stack);
				inserted = true;
			} else if (data.get(index).start < insert.start) {
				addInterval(data.get(index), stack);
				index += 1;
			} else {
				addInterval(insert, stack);
				inserted = true;
			}
		}
		
		return new ArrayList<>(stack);
	}

	public static void addInterval(Interval obj, Stack<Interval> stack) {
		if (stack.isEmpty()) {
			stack.push(obj);
			return;
		}

		if (isOverlapped(stack.peek(), obj)) {
			Interval top = stack.pop();
			obj.start = Math.min(obj.start, top.start);
			obj.end = Math.max(obj.end, top.end);
		}

		stack.push(obj);
	}

	/**
	 *  45. Jump Game II 
	 *   Given an array of non-negative integers, you are initially
	 *   positioned at the first index of the array.
	 *
	 *   BFS
	 *   Time: O(n)
	 *   Space: O(n)
	 */
	public static int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] step = new int[nums.length];
		for (int i = 1; i < step.length; ++i) {
			step[i] = Integer.MAX_VALUE;
		}
		boolean[] visited = new boolean[nums.length];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			visited[cur] = true;	

			if (cur == nums.length - 1) {
				break;
			}

			for (int i = 1; i <= nums[cur]; ++i) {
				int next = cur + i;
				if (next < nums.length && !visited[next]) {
					queue.add(next);
					step[next] = Math.min(step[next], step[cur] + 1);
				}
			}
		}

		return step[nums.length - 1];
	}
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

      public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.
		      append('[').
		      append(start).
		      append(", ").
		      append(end).
		      append(']');

	      return builder.toString();
      }
}
