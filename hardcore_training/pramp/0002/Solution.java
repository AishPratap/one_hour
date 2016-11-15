import java.util.*;

public class Solution {

	public static void main(String[] args) {
		drawHTree(0, 0, 22, 1);
	}

	/**
	 * Suppose that it is already implemented properly
	 */
	public static void line(double x0, double y0, double x1, double y1) {
		System.out.printf("Draw a line from (%f, %f) to (%f, %f)\n",
				x0, y0, x1, y1);
	}

	/**
	 * Time O(4^D)
	 * Space O(D)
	 */
	public static void drawHTree(double x, double y, double length, int depth) {
		if (depth <= 0) {
			return;
		}

		// Prepare variables
		double x0 = x - length / 2;
		double y0 = y + length / 2;
		
		double x1 = x + length / 2;
		double y1 = y + length / 2;

		double x2 = x + length / 2;
		double y2 = y - length / 2;

		double x3 = x - length / 2;
		double y3 = y - length / 2;

		double newLength = Math.sqrt(length);

		// Draw three lines
		line(x - length / 2, y, x + length / 2, y);
		line(x0, y0, x3, y3);
		line(x1, y1, x2, y2);

		drawHTree(x0, y0, newLength, depth - 1);
		drawHTree(x1, y1, newLength, depth - 1);
		drawHTree(x2, y2, newLength, depth - 1);
		drawHTree(x3, y3, newLength, depth - 1);
	}
}
