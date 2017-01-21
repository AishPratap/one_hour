/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class AppleOrange {

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
			int s, t;
			s = in.nextInt();
			t = in.nextInt();
			int a, b;
			a = in.nextInt();
			b = in.nextInt();
			int m, n;
			m = in.nextInt();
			n = in.nextInt();
	
			int apples = 0, oranges = 0;

			for (int i = 0; i < m; ++i) {
				int cur = in.nextInt();
				int pos = a + cur;
				if (pos >= s && pos <= t) {
					apples += 1;
				}
			}

			for (int i = 0; i < n; ++i) {
				int cur = in.nextInt();
				int pos = b + cur;
				if (pos >= s && pos <= t) {
					oranges += 1;
				}
			}
			out.println(apples);
			out.println(oranges);
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
