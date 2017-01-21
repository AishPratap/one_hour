/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class LeftRotation {

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
			int n, d;
			n = in.nextInt();
			d = in.nextInt();

			int[] data = new int[n];
			for (int i = 0; i < n; ++i) {
				data[i] = in.nextInt();
			}

			rotate(data, d);

			for (int i = 0; i < n; ++i) {
				out.print(data[i] + " ");
			}
			out.println();
		}

		public void rotate(int[] data, int d) {
			d %= data.length;
			d = data.length - d;
			if (d == 0) {
				return;
			}
			
			reverse(data, 0, data.length);
			reverse(data, 0, d);
			reverse(data, d, data.length);
		}

		public void reverse(int[] data, int start, int end) {
			end -= 1;
			while (start < end) {
				int temp = data[start];
				data[start] = data[end];
				data[end] = temp;

				start += 1;
				end -= 1;
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
