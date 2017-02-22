import java.util.*;

public class LongestConsecutiveSequence2 {

	public static void main(String[] args) {
		int[] data =
		{0, 0};
		System.out.println(longestConsecutive(data));
	}

	public static int longestConsecutive(int[] data) {
		int ret = 0;
		
		UnionFind uf = new UnionFind();

		for (int it : data) {
			uf.add(it);
			uf.union(it, it - 1);
			uf.union(it, it + 1);
		}

		for (int it : uf.getGroup().values()) {
			ret = Math.max(ret, it);
		}

		return ret;
	}

	static class UnionFind {

		Map<Integer, Integer> up = new HashMap<>();
		Map<Integer, Integer> depth = new HashMap<>();
		Map<Integer, Integer> group = new HashMap<>();

		public void add(int key) {
			if (up.containsKey(key)) {
				// In case of duplication!
				return;
			}

			up.put(key, key);
			depth.put(key, 1);
			group.put(key, 1);
		}

		public int find(int key) {
			int parent = key;
			while (parent != up.get(parent)) {
				parent = up.get(parent);
			}
			up.put(key, parent);

			return parent;
		}

		public void union(int src1, int src2) {
			if (!up.containsKey(src1) || !up.containsKey(src2)) {
				return;
			}

			int parent1 = find(src1);
			int parent2 = find(src2);

			if (parent1 == parent2) {
				return;
			}

			if (depth.get(parent1) > depth.get(parent2)) {
				merge(parent1, parent2);
			} else {
				merge(parent2, parent1);
			}
		}

		public Map<Integer, Integer> getGroup() {
			return group;
		}

		private void merge(int big, int small) {
			up.put(small, big);
			int newDepth = Math.max(depth.get(big),
						depth.get(small) + 1);
			depth.put(big, newDepth);
			group.put(big,
				group.get(big) + group.get(small));
			group.remove(small);
		}
	}
}

