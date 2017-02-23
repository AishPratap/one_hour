/**
 * Failed attempt to solve with O(nlogn)
 */

import java.util.*;

public class LongestIncreasingSubsequence2 {
	
	public static void main(String[] args) {
		int[] data = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis(data));
	}

	public static int lis(int[] data) {
		int ret = 1;
		int n = data.length;

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(data[n - 1], 1);

		for (int i = n - 2; i >= 0; --i) {
			int tmp =  1;

			/* Bug here  */
			Integer higher = treeMap.higherKey(data[i]);

			System.out.printf("debug: cur = %d, higher = %d\n", data[i], higher);
			if (higher != null) {
				System.out.println("debug:val_higher: " + treeMap.get(higher));
			}

			if (higher != null) {
				tmp += treeMap.get(higher);
			}
		
			System.out.printf("debug:putting %d, %d\n", data[i], tmp);
			ret = Math.max(ret, tmp);
			treeMap.put(data[i], tmp);
		}

		System.out.println("debug:map: " + treeMap);

		return ret;
	}
}

