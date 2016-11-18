import java.util.*;
import java.io.*;

public class Solution {

	public void main(String[] args) throws Exception {
		File inFile = new File("input.txt");
		Scanner scan = new Scanner(inFile);

		int col = scan.nextInt();
		int row = scan.nextInt();

		int[][] matrix = new int[row][col];
		boolean[][] visited = new boolean[row][col];

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				matrix[row][col] = scan.nextInt();
			}
		}

		System.out.println(countIsland(matrix));
	}

	public static int countIsland(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		boolean[][] visited = new boolean[row][col];

		int counter = 0;

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (!visited[i][j]) {
					counter += 1;
					markIsland(matrix, i, j, visited);
				}
			}
		}

		return counter;
	}

	public static void markIsland(int[][] matrix, int row,
			int col, boolean[][] visited) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(row, col));

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			int curRow = cur.a;
			int curCol = cur.b;

			visited[curRow][curCol] = true;
		
			// To lazy to write the rest
			// Baiscally, it's just BFS with a queue
		}
	}
}

class Pair {
	int a, b;
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
