/*
 * hoang_khoi
 */
import java.io.*;
import java.util.*;

public class DynamicArray {

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
			q = in.nextInt();

			List<List<Integer>> seqList = new ArrayList<>();
			for (int i = 0; i < n; ++i)	 {
				seqList.add(new ArrayList<>());
			}

			int lastAns = 0;
			for (int i = 0; i < q; ++i) {
				int type, x, y;
				type = in.nextInt();
				x = in.nextInt();
				y = in.nextInt();
				int index = (x ^ lastAns) % n;
				List<Integer> seq = seqList.get(index);
				if (type == 1) {
					seq.add(y);
				} else {
					int ind = y % seq.size();
					lastAns = seq.get(ind);
					out.println(lastAns);
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
