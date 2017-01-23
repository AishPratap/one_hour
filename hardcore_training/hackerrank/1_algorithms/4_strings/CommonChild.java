/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class CommonChild {

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
			String a, b;
			a = in.next();
			b = in.next();

			int size = a.length();

			int[][] matrix = new int[size + 1][size + 1];
			for (int i = 0; i < size + 1; ++i) {
				for (int j = 0; j < size + 1; ++j) {
					if (i == 0 || j == 0) {
						matrix[i][j] = 0;
					} else {
						if (a.charAt(i - 1) == b.charAt(j - 1)) {
							matrix[i][j] = matrix[i - 1][j - 1] + 1;
						} else {
							matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
						}
					}
				}
			}

			out.println(matrix[size][size]);
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
