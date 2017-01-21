/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class SparseArray {

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
			int n, q;
			n = in.nextInt();
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; ++i) {
				String key = in.next();
				if (!map.containsKey(key)) {
					map.put(key, 0);
				}
				map.put(key, map.get(key) + 1);
			}

			q = in.nextInt();
			for (int i = 0; i < q; ++i) {
				String key = in.next();
				if (!map.containsKey(key)) {
					out.println(0);
				} else {
					out.println(map.get(key));
				}
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
	}	
}
