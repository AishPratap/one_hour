/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class Array2D {

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
			int[][] data = new int[6][6];
			for (int i = 0; i < 6; ++i) {
				for (int j = 0; j < 6; ++j) {
					data[i][j] = in.nextInt();
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= 3; ++i) {
				for (int j = 0; j <= 3; ++j) {
					int sum = data[i][j] + data[i][j + 1] + data[i][j + 2]
						+ data[i + 1][j + 1] + data[i + 2][j] + data[i + 2][j + 1]
						+ data[i + 2][j + 2];
					max = Math.max(sum, max);
				}
			}
			out.println(max);
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
	}	
}
