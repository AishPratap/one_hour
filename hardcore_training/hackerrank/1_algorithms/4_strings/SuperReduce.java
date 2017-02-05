/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class SuperReduce {

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
			String str = in.next();
			boolean changed = true;

			while (changed) {
				changed = false;
				for (int i = 0; i < str.length() - 1; ++i) {
					if (str.charAt(i) == str.charAt(i + 1)) {
						changed = true;
						str = removePair(str, i);
					}
				}
			}

			out.println(str.isEmpty() ? "Empty String" : str);
		}

		public String removePair(String str, int pos) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < pos; ++i) {
				sb.append(str.charAt(i));
			}

			for (int i = pos + 2; i < str.length(); ++i) {
				sb.append(str.charAt(i));
			}

			return sb.toString();
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

		public String[] nextArray(int size) {
			String[] ret = new String[size];
			for (int i = 0; i < size; ++i) {
				ret[i] = next();
			}
			return ret;
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
