/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class FindTheMedian {

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
			int[] data = in.nextIntArray(n);

			int left = 0, right = n - 1;
			int medInd = partition(data, left, right);
			while (medInd != n / 2) {
				if (medInd > n / 2) {
					right = medInd - 1;
				} else {
					left = medInd + 1;
				}
				medInd = partition(data, left, right);
			}

			out.println(data[medInd]);
		}

		public int partition(int[] data, int startInd, int endInd) {
			int leftPnt = startInd + 1;
			int rightPnt = endInd;

			while (leftPnt <= rightPnt) {
				while (leftPnt <= endInd && data[leftPnt] <= data[startInd]) {
					leftPnt += 1;
				}
				while (rightPnt >= startInd && data[rightPnt] > data[startInd]) {
					rightPnt -= 1;
				}

				if (leftPnt <= rightPnt) {
					swap(data, leftPnt, rightPnt);
					leftPnt += 1;
					rightPnt -= 1;
				}
			}

			swap(data, startInd, leftPnt - 1);
			return leftPnt - 1;
		}

		public void swap(int[] data, int ind1, int ind2) {
			int temp = data[ind1];
			data[ind1] = data[ind2];
			data[ind2] = temp;
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
