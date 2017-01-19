
/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class CircleArrayRotation {

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
			int rotation = in.nextInt();
			int query = in.nextInt();

			int[] data = new int[n];
			for (int i = 0; i < n; ++i) {
				data[i] = in.nextInt();
			}

			rotate(data, rotation);
			for (int i = 0; i < query; ++i) {
				out.println(data[in.nextInt()]);
			}
		}

		public void rotate(int[] data, int rotation) {
			rotation %= data.length;
			if (rotation == 0) {
				return;
			}

			reverse(data, 0, data.length);
			reverse(data, 0, rotation);
			reverse(data, rotation, data.length);
		}

		public void reverse(int[] data, int from, int to) {
			int left = from, right = to -  1;
			while (left < right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left += 1;
				right -= 1;
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
