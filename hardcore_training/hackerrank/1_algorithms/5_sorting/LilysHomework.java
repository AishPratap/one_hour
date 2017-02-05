/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class LilysHomework {

	public static void main(String[] args) throws Exception {
		boolean fileInput = true;
		InputStream inputStream = fileInput ? new FileInputStream("input.txt") : System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		Task task = new Task();
		task.solve(in, out);

		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			// Logic goes here
			int n = in.nextInt();

			int[] raw = new int[n];
			int[] sorted = new int[n];

			for (int i = 0; i < n; ++i) {
				raw[i] = in.nextInt();
				sorted[i] = raw[i];
			}

			Arrays.sort(sorted);


			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				map.put(sorted[i], i);
			}

			UnionFind set = new UnionFind(n);

			for (int i = 0; i < n; ++i) {
				int j = map.get(raw[i]);
				set.union(i, j);
			}

			int ret = 0;

			for (int num : set.memberList()) {
				ret += (num - 1);
			}

			out.println(ret);
		}

		class UnionFind {

			public Map<Integer, Integer> upper = new HashMap<>();
			public Map<Integer, Integer> depth = new HashMap<>();
			public Map<Integer, Integer> rep = new HashMap<>();

			public UnionFind(int size) {
				for (int i = 0; i < size; ++i) {
					rep.put(i, 1);
					upper.put(i, i);
					depth.put(i, 0);
				}
			}

			public void union(int a, int b) {
				int rootA = find(a);
				int rootB = find(b);

				if (rootA == rootB) {
					return;
				}

				if (depth.get(rootA) > depth.get(rootB)) {
					merge(rootA, rootB);
				} else {
					merge(rootB, rootA);
				}
			}

			public int find(int target) {
				int copy = target;
				while (target != upper.get(target)) {
					target = upper.get(target);
				}

				upper.put(copy, target);

				return target;
			}

			public List<Integer> memberList() {
				return new ArrayList<>(rep.values());
			}

			private void merge(int root, int branch) {
				int rootDepth = depth.get(root);
				if (rootDepth == depth.get(branch)) {
					depth.put(root, rootDepth + 1);
				}

				rep.put(root,rep.get(root) +rep.get(branch));
				rep.remove(branch);

				upper.put(branch, root);
			}
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public float nextFloat() {
			return Float.parseFloat(next());
		}

		public int[] nextIntArray(int size) {
			int[] ret = new int[size];
			for (int i = 0; i < size; ++i) {
				ret[i] = nextInt();
			}

			return ret;
		}

		public long[] nextLongArray(int size) {
			long[] ret = new long[size];
			for (int i = 0; i < size; ++i) {
				ret[i] = nextLong();
			}

			return ret;
		}

		public float[] nextFloatArray(int size) {
			float[] ret = new float[size];
			for (int i = 0; i < size; ++i) {
				ret[i] = nextFloat();
			}

			return ret;
		}

		public double[] nextDoubleArray(int size) {
			double[] ret = new double[size];
			for (int i = 0; i < size; ++i) {
				ret[i] = nextFloat();
			}

			return ret;
		}
	}	
}
