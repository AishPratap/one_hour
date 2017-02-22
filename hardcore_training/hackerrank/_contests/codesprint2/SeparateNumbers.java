/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class SeparateNumbers {

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
			 //Logic goes here

			int n = in.nextInt();
			while (n-- > 0) {
				long ret = splitString(in.next());
				if (ret >= 0) {
					System.out.println("YES " + ret);
				} else {
					System.out.println("NO");
				}
			}
		}

		public long splitString(String str) {
			int size = str.length();
			int limit = size / 2;

			for (int i = 1; i <= limit; ++i) {
				long ret = splitString(str, i);
				if (ret >= 0) {
					return ret;
				}
			}

			return -1;
		}

		public long splitString(String str, int init) {
			int step = init;
			int p = 0;
			long ret = 0;
			long pre = 0, cur = 0;
			boolean initialized = false;
			String sub = "";

			while (p + step <= str.length()) {
				if (!initialized) {
					initialized = true;
					sub = str.substring(p, p + step);
					if (step > 1 && sub.charAt(0) == '0') {
						return -1;
					}

					cur = Long.parseLong(sub);
					ret = cur;
					p += step;
					step = String.valueOf(cur + 1).length();

					continue;
				}

				pre = cur;
				sub = str.substring(p, p + step);

				if (step > 1 && sub.charAt(0) == '0') {
					return -1;
				}

				cur = Long.parseLong(sub);
				p += step;
				step = String.valueOf(cur + 1).length();


				if (pre + 1 != cur) {
					return -1;
				}
			}

			return ret;
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

