/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class MoonJourney {

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
			int m = in.nextInt();

			Map<Integer, Integer> rep = new HashMap<>();
			Map<Integer, Integer> rel = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				rep.put(i, 1);
			}

			int line = 2;

			while (m-- > 0) {
				int first = in.nextInt();
				int second = in.nextInt();

				while (rel.containsKey(first)) {
					first = rel.get(first);
				}

				while (rel.containsKey(second)) {
					second = rel.get(second);
				}

				if (first != second) {
					rep.put(first, rep.get(first) + rep.get(second));
					rep.remove(second);
					rel.put(second, first);
				}

			}

			List<Integer> list = new ArrayList<>(rep.values());
			long ret = 0;
			for (int i = 0; i < list.size() - 1; ++i) {
				for (int j = i + 1; j < list.size(); ++j) {
					long product = list.get(i) * list.get(j);
					ret += product;
				}
			}
			out.println(ret);
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
