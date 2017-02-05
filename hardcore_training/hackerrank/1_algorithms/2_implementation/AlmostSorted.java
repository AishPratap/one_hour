/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class AlmostSorted {

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
			int n = in.nextInt();
			int[] raw = new int[n];
			int[] sorted = new int[n];
		
			for (int i = 0; i < n; ++i) {
				raw[i] = in.nextInt();
				sorted[i] = raw[i];
			}

			Arrays.sort(sorted);

			int index = 0;
			while (index < n && raw[index] == sorted[index]) {
				index += 1;
			}

			if (index == n) {
				out.println("yes");
				return;
			}


			int[] swap = canSwap(raw, sorted, index);
			if (swap != null) {
				out.println("yes");
				out.println("swap " + (swap[0] + 1) + " " + (swap[1] + 1));
				return;
			}

			int[] reverse = canReverse(raw, sorted, index);
			if (reverse != null) {
				out.println("yes");
				out.println("reverse " + (reverse[0] + 1) + " " + (reverse[1] + 1));
				return;
			}

			out.println("no");
		}

		public int[] canSwap(int[] data, int[] sorted, int abnormal) {
			int other = -1;

			for (int i = abnormal + 1; i < data.length; ++i) {
				if (data[i] != sorted[i]) {
					other = i;
					break;
				}
			}

			if (other == -1) {
				return null;
			}

			int[] clone = new int[data.length];
			System.arraycopy(data, 0, clone, 0, data.length);

			swap(clone, abnormal, other);
			
			if (!Arrays.equals(clone, sorted)) {
				return null;
			}

			return new int[] {abnormal, other};
		}

		public int[] canReverse(int[] data, int[] sorted, int abnormal) {
			int index = abnormal;
			while (index + 1 < data.length && data[index] > data[index + 1]) {
				index += 1;
			}

			if (index == abnormal) {
				return null;
			}

			int[] clone = new int[data.length];
			System.arraycopy(data, 0, clone, 0, data.length);

			reverse(clone, abnormal, index);

			if (!Arrays.equals(clone, sorted)) {
				return null;
			}

			return new int[] {abnormal, index};
		}

		public void swap(int[] data, int ind1, int ind2) {
			int temp = data[ind1];
			data[ind1] = data[ind2];
			data[ind2] = temp;
		}

		public void reverse(int[] data, int ind1, int ind2) {
			while (ind1 < ind2) {
				int temp = data[ind1];
				data[ind1] = data[ind2];
				data[ind2] = temp;

				ind1 += 1;
				ind2 -= 1;
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
