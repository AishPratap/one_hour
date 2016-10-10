import java.util.*;

public class Chap02 {

	public static void main(String[] args) {
	}
	
	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	static class LinkedList {
		Node head, tail;
		
		public void add(int val) {
			if (head == null) {
				head = new Node(val);
			} else if (tail == null) {
				tail = new Node(val);
				head.next = tail;
			} else {
				tail.next = new Node(val);
				tail = tail.next;
			}
		}
	}

	public static String toString(Node head) {
		Node iterator = head;
		boolean comma= false;
		StringBuilder builder = new StringBuilder();
		while (iterator != null) {
			if (comma) {
				builder.append(', ');
			}
		}
	}
}
