import java.util.*;

public class Chap02 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(12321);
		System.out.println(isPalindrome(list));
	}

	/**
	 * Remove duplication in a linked-list
	 * Time: O(n); Space: O(n)
	 */
	public static void removeDuplication(LinkedList list) {
		if (list == null || list.head == null || list.tail == null) {
			return;
		}

		HashSet<Integer> set= new HashSet<>();
		Node iterator = list.head;

		while (iterator.next != null) {
			set.add(iterator.val);
			if (set.contains(iterator.next.val)) {
				iterator.removeNext();
			} else {
				iterator = iterator.next;
			}
		}
	}

	/**
	 * Same as above, but no buffer
	 * Time: O(n*2); Space: O(1)
	 */ 
	public static void removeDuplication2(LinkedList list) {
		if (list == null || list.head == null || list.tail == null) {
			return;
		}
		Node iterator = list.head;
		while (iterator != null) {
			Node subIterator = iterator;
			while (subIterator.next != null) {
				if (subIterator.next.val == iterator.val) {
					subIterator.removeNext();
				} else {
					subIterator = subIterator.next;
				}
			}
			iterator = iterator.next;
		}
	}

	/**
	 * Find the kth last element of a linkedlist
	 * Time: O(n); Space: O(1)
	 */
	public static Node kthLast(LinkedList list, int k) {
		if (list == null || list.head == null) {
			return null;
		}
		
		if (list.tail == null) {
			return list.head;
		}

		Node camper = list.head;
		Node runner = list.head; 

		for (int i = 0; i < k; ++i) {
			runner = runner.next;
			if (runner == null) {
				break;
			}
		}

		while (runner != null) {
			runner = runner.next;
			camper = camper.next;
		}

		return camper;
	}

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}

		public String toString() {
			return val + "";
		}

		public void dump() {
			Node iterator = this;
			while (iterator != null) {
				System.out.print(iterator + " ");
				iterator = iterator.next;
			}
			System.out.println();
		}

		public void removeNext() {
			if (this == null) {
				return;
			}
			this.next = this.next.next;
		}
	}

	/**
	 * Remove a node in the middle of linkedlist, given that node in argument
	 * Assume that this linkedlist has more than 2 nodes, and the node to
	 * remove is located at the middle
	 * Time: O(n); Space: O(1)
	 */
	public static void removeMiddleNode(Node node) {
		Node iterator = node;
		while (true) {
			iterator.val = iterator.next.val;
			if (iterator.next.next == null) {
				iterator.next = null;
				break;
			}
			iterator = iterator.next;
		}
	}

	/**
	 * Parition a linked list
	 * Time: O(n); Space: O(1)
	 */
	public static void partition(LinkedList list, int pivot) {
		if (list == null || list.head == null || list.tail == null) {
			return;
		}

		Node iterator = list.head;

		Node leftHead = null;
		Node leftTail = null;

		Node rightHead = null;
		Node rightTail = null;

		while (iterator != null) {
			Node current = iterator;
			iterator = iterator.next;

			if (current.val == pivot) {
				if (leftHead == null) {
					leftHead = current;
					leftHead.next = null;
				} else if (leftTail == null) {
					leftTail = current;
					leftHead.next = leftTail;
					leftTail.next = null;
				} else {
					leftTail.next = current;
					leftTail = leftTail.next;
					leftTail.next = null;
				}
			} else if (current.val > pivot) {
				if (rightHead == null) {
					rightHead = current;
					rightHead.next = null;
				} else if (rightTail == null) {
					rightTail = current;
					rightHead.next = rightTail;
					rightTail.next = null;
				} else {
					rightTail.next = current;
					rightTail = rightTail.next;
					rightTail.next = null;
				}
			} else {
				if (leftHead == null) {
					leftHead = current;
					leftHead.next = null;
				} else if (leftTail == null) {
					leftTail = leftHead;
					leftHead = current;
					leftHead.next = leftTail;
					leftTail.next = null;
				} else {
					current.next = leftHead;
					leftHead = current;
					leftTail.next = null;
				}
			}
		}

		leftTail.next = rightHead;
		leftHead.dump();
	}

	/**
	 * 7-1-6 + 5-9-2 = 2-1-9 that is 617+295=912
	 * Time: O(n) ;Space: O(n)
	 */
	public static LinkedList addTwoLists(LinkedList list0, LinkedList list1) {
		int listInt0 = list0.toInt();
		int listInt1 = list1.toInt();

		return new LinkedList(listInt0 + listInt1);
	}

	/**
	 * Same as above, but do it the hard way
	 * Time: O(n); Space: O(n)
	 */
	public static LinkedList addTwoLists2(LinkedList list0, LinkedList list1) {
		LinkedList result = new LinkedList();
		
		Node iterator0 = list0.head;
		Node iterator1 = list1.head;

		int carry = 0;

		while (iterator0 != null || iterator1 != null) {
			int num0 = iterator0 == null ? 0 : iterator0.val;
			int num1 = iterator1 == null ? 0 : iterator1.val;

			int sum = num0 + num1 + carry;
			carry = sum / 10;
			sum %= 10;

			result.add(sum);
			if (iterator0 != null) {
				iterator0 = iterator0.next;
			}
			if (iterator1 != null) {
				iterator1 = iterator1.next;
			}
		}
		if (carry > 0) {
			result.add(carry);
		}

		return result;
	}

	/*
	 * Same as above, but in a natural order
	 * Time: O(n); Space: O(n)
	 * */
	public static LinkedList addTwoLists3(LinkedList list0, LinkedList list1) {
		int num0 = list0.toIntRev();
		int num1 = list1.toIntRev();

		return new LinkedList(num0 + num1, true);
	}

	/**
	 * Given a circular linkedlist, return the node where the loop begins
	 * Time: O(n); Space O(n)
	 */
	public static Node getLoopBegin(Node head) {
		if (head == null) {
			return null;
		}

		HashSet<Node> set = new HashSet<>();

		for (Node iterator = head; iterator != null; iterator = iterator.next) {
			if (set.contains(iterator)) {
				return iterator;
			}
			set.add(iterator);
		}

		return null;
	}
	

	/**
	 * Another version which is better in term of memory, circular linkedlist
	 * guaranteed
	 * Time: O(n); Space: O(1)
	 */
	public static Node getLoopBegin2(Node head) {
		if (head == null) {
			return null;
		}

		Node iterator0 = head;
		Node iterator1 = head;

		do {
			iterator0 = iterator0.next;
			iterator1 = iterator1.next.next;
		} while (iterator0 != iterator1);

		return iterator0;
	}

	/**
	 * Check if a linkedlist is palindrome
	 * Time: O(n); Space: O(n)
	 */
	public static boolean isPalindrome(LinkedList list) {
		if (list == null || list.head == null || list.tail == null) {
			return true;
		}

		Stack<Integer> stack = new Stack<>();
		for (Node iterator = list.head; iterator != null;
				iterator = iterator.next) {
			stack.push(iterator.val);
		}
		
		for (Node iterator = list.head; iterator != null;
				iterator = iterator.next) {
			if (stack.pop() != iterator.val) {
				return false;
			}
		}
		return true;
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

		public LinkedList() {
			this.head = null;
			this.tail = null;
		}

		public LinkedList(int number) {
			while (number > 0) {
				int lastNum = number % 10;
				number /= 10;
				this.add(lastNum);
			}
		}

		public LinkedList(int number, boolean flag) {
			for (int digits = (int) Math.log10(number); digits >= 0;
					--digits) {
				int tenPower = (int) Math.pow(10, digits);
				int cur = number / tenPower;
				number %= tenPower;
				this.add(cur);
			}
		}
		
		public int toInt() {
			int mul = 0;
			Node iterator = this.head;
			int result = 0;
			while (iterator != null) {
				result += (iterator.val * Math.pow(10, mul));
				mul += 1;
				iterator = iterator.next;
			}

			return result;
		}

		public int toIntRev() {
			int result = 0;
			
			for (Node iterator = this.head; iterator != null;
					iterator = iterator.next) {
				result = result * 10 + iterator.val;
			}

			return result;
		}	
	}
}
