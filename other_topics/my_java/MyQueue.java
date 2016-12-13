import java.io.*;
import java.util.*;

/**
 * Important methods to remember
 *	poll()
 *	add()
 *	peek()
 *	isEmpty()
 */
public class MyQueue {
:q

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < 10; ++i) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
