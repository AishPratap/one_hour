import java.io.*;
import java.util.*;

/**
 * Java PriorityQueue API
 *
 * Core functions:
 * add(T)
 * poll()
 * isEmpty()
 *
 * Default, PriorityQueue is a min queue
 */
public class MyPriorityQueue {

	public static void main(String[] argv) {
		Random rand = new Random();
		Queue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < 10; ++i) {
			queue.add(rand.nextInt(10000));
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
