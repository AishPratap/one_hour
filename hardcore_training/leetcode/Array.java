import java.util.*;
import java.io.*;

public class Array {

	public static void main(String[] args) {
		Interval[] ar = {
			new Interval(2, 3),
			new Interval(4, 5),
			new Interval(6, 7),
			new Interval(8, 9),
			new Interval(1, 10)
		};

		List<Interval> result = merge(Arrays.asList(ar));
		System.out.println(result);
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

	public static boolean isOverlapped(Interval a, Interval b) {
		// a.end >= b.start and a.end <= b.end or other wayA
		return (a.end >= b.start && a.end <= b.end) ||
			(b.end >= a.start && b.end <= a.end);
	}
	/*
		[1,3],[2,6],[8,10],[15,18],
		*
		1,3
		15, 18

		input: list<interval>

		treeset - comparison is based on start time
		for each interval in the list:
			floor = treeset.floor(cur_interval)
			if floor is not null:
				cur_interval is overlapped with floor:
					cur_interval.start = min()
					cur_interval.end = max()
					treeset.remove(floor)
			treeset.add(cur_interval)
			
			do the same with ceiling
	 * */
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
