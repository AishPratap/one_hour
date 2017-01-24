/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class MergingCommunities {

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
			int q = in.nextInt();

			DisjointSet set = new DisjointSet(n);

			while (q-- > 0) {
				String cmd = in.next();
				if (cmd.equals("M")) {
					int first = in.nextInt();
					int second = in.nextInt();
					set.connect(first - 1, second - 1);
				} else {
					int id = in.nextInt();
					out.println(set.componentSize(id - 1));
				}
			}
		}

		class DisjointSet {
			private Map<Integer, Integer> rep = new HashMap<>();
			private Map<Integer, Integer> up = new HashMap<>();
			private Map<Integer, Integer> rank = new HashMap<>();

			public DisjointSet(int n) {
				for (int i = 0; i < n; ++i) {
					rep.put(i, 1);
					rank.put(i, 0);
					up.put(i, i);
				}
			}

			public void connect(int id1, int id2) {
				int rep1 = getRepresentative(id1);
				int rep2 = getRepresentative(id2);
				if (rep1 != rep2) {
					if (rank.get(rep1) > rank.get(rep2)) {
						merge(rep1, rep2);
					} else {
						merge(rep2, rep1);
					}
				}
			}

			public void merge(int main, int branch) {
				rep.put(main, rep.get(main) + rep.get(branch));
				up.put(branch, main);
				rank.put(main, Math.max(rank.get(main), 1 + rank.get(branch)));
			}

			public int componentSize(int id) {
				int repId = getRepresentative(id);
				return rep.get(repId);
			}

			public int getRepresentative(int id) {
				int ret = id;

				while (ret != up.get(ret)) {
					ret = up.get(ret);
				}

				up.put(id, ret);

				return ret;
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
