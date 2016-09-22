import java.util.*;

public class Chap01 {

	public static void main(String args[]) {
		
	}

	/**
	 * Basic node to form a linked list
	 */
	class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * Remove all duplications in an unsorted linked list
	 */
	public void removeDuplication(Node root) {
		if (root == null) {
			return;
		}

		Node iterator = root;
		
	}
}
