import java.util.*;

public class Chap01 {

	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(6);
		list.add(5);
		list.add(1);
		list.add(9);
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(15);
		list.add(12);
		list.add(8);
		list.add(7);
		list.add(8);
		list.add(1);
		list.add(16);
	
		//partition(list, 8);
		System.out.println(list);
	}
	

	/**
	 * Remove all duplications in an unsorted linked list
	 * * Complexity: O(n)
	 */
	public static void removeDuplication(SinglyNode head) {
		HashSet<Integer> existed = new HashSet<>();
		SinglyNode cur = head;
		while (cur != null) {
			existed.add(cur.val);
			while (cur.next != null 
					&& existed.contains(cur.next.val)) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
	}

	/**
	 * Same as above, but no additional data structures
	 * Complexity: O(n);
	 */
	public static void removeDuplication2(SinglyNode head) {
		SinglyNode cur = head;
		while (cur != null) { // iterate all nodes
			SinglyNode runner = cur;
			while (runner.next != null) {
				// iterate all things from current node
				if (runner.next.val == cur.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			cur = cur.next;
		}
	}

	/**
	 * Find the kth last node in a linked list
	 * Complexity:O(n)
	 */
	public static SinglyNode kthLastNode(int k, SinglyNode head) {
		SinglyNode p0 = head;
		SinglyNode p1 = head;
		for (int i = 0; i < k; ++i) {
			if (p1 == null) {
				return p0;
			}
			p1 = p1.next;
		}
		while (p1 != null) {
			p1 = p1.next;
			p0 = p0.next;
		}

		return p0;
	}

	/**
	 * Given a node in a linked list
	 * Remove that node
	 * That node is in the middle of linked list
	 * Complexity O(n)
	 */
	public static void removeMiddle(SinglyNode node) {
		SinglyNode cur = node;
		while(true) {
			cur.val = cur.next.val;
			if (cur.next.next == null) {
				cur.next = null;
				break;
			}
			cur = cur.next;
		}
	}

	/**
	 * Print the linked list, start with head
	 */
	public static void printNodes(SinglyNode head) {
		SinglyNode current = head;
		while (current != null) {
			System.out.print(current);
			System.out.print(' ');
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * Partition a linnked-list
	 */
	public static void partition(SinglyLinkedList list, int value) {
		if (list.head == null || list.tail == null) {
			return;
		}

		
	}
}

/**
 * Basic node to form a linked list
 */
class SinglyNode {
	public int val;
	public SinglyNode next;

	public SinglyNode(int val) {
		this.val = val;
		this.next = null;
	}

	@Override
	public String toString() {
		return val + "";
	}
}

/**
 * Linked list
 * SinglyNode wrapper basically
 */
class SinglyLinkedList {
	public SinglyNode head = null;
	public SinglyNode tail = null;

	public void add(int val) {
		if (head == null) {
			head = new SinglyNode(val);
		} else {
			if (tail == null) {
				tail = new SinglyNode(val);
				head.next =tail;
			} else {
				tail.next = new SinglyNode(val);
				tail = tail.next;
			}
		}
	}

	@Override
	public String toString() {
		SinglyNode iterator = head;
		StringBuilder builder = new StringBuilder();
		while (iterator != null) {
			builder.append(iterator).append(' ');
			iterator = iterator.next;
		}

		return builder.toString();
	}
}
