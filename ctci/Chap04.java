import java.util.*;

public class Chap04 {
	public static void main(String[] args) {
		BinNode node90 = new BinNode(90);
		BinNode node50 = new BinNode(50);
		BinNode node150 = new BinNode(150);
		BinNode node20 = new BinNode(20);
		BinNode node75 = new BinNode(75);
		BinNode node95 = new BinNode(95);
		BinNode node175 = new BinNode(175);
		BinNode node5 = new BinNode(5);
		BinNode node25 = new BinNode(25);
		BinNode node66 = new BinNode(66);
		BinNode node80 = new BinNode(80);
		BinNode node92 = new BinNode(92);
		BinNode node111 = new BinNode(111);
		BinNode node166 = new BinNode(166);
		BinNode node200 = new BinNode(200);

		node90.addRight(node150);
		node90.addLeft(node50);

		node50.addLeft(node20);
		node50.addRight(node75);

		node150.addLeft(node95);
		node150.addRight(node175);

		node20.addLeft(node5);
		node20.addRight(node25);

		node75.addLeft(node66);
		node75.addRight(node80);

		node95.addLeft(node92);
		node95.addRight(node111);

		node175.addLeft(node166);
		node175.addRight(node200);

		BinNode n50 = new BinNode(50);
		BinNode n20 = new BinNode(20);
		BinNode n75 = new BinNode(75);
		BinNode n66 = new BinNode(66);

		n50.addRight(n75);
		n50.addLeft(n20);

		n75.addLeft(n66);
		System.out.println(n50.isSubTree(node90));
	}

	/**
	 * Default height = -1
	 * Time: O(n): n number of node
	 */
	private static int height(BinNode root, int height) {
		if (root == null) {
			return height;
		}

		int heightLeft = height(root.left, height + 1);
		int heightRight = height(root.right, height + 1);

		return Math.max(heightLeft, heightRight);
	}

	public static int height(BinNode root) {
		return height(root, -1);
	}

	public static void preOrder(BinNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(BinNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public static void postOrder(BinNode root) {
		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	public static void BFS(BinNode root) {
		if (root == null) {
			return;
		}
		Queue<BinNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinNode cur = queue.poll();
			System.out.print(cur.val + " ");
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	/**
	 * Check if a binary tree is balanced
	 * Time: O(n^2)
	 */
	public static boolean isBalanced(BinNode root) {
		if (root == null) {
			return true;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		boolean current = Math.abs(leftHeight - rightHeight) <= 1;
		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);

		return current && left && right;
	}

	/**
	 * Generate the shortest bintree from a sorted array
	 * Time: O(n)
	 */
	public static BinNode generateTree(int[] data, int left, int right) {
		if (left == right) {
			return new BinNode(data[left]);
		} else if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		BinNode midNode = new BinNode(data[mid]);
		BinNode leftNode = generateTree(data, left, mid - 1);
		BinNode rightNode = generateTree(data, mid + 1, right);
		midNode.addLeft(leftNode);
		midNode.addRight(rightNode);

		return midNode;
	}
	
	public static BinNode generateTree(int[] data) {
		if (data == null || data.length == 0) {
			return null;
		}

		return generateTree(data, 0, data.length - 1);
	}

	/**
	 * Print the layers of a binary tree
	 * Time: O(n)
	 */
	public static void genLayers(BinNode root) {
		if (root == null) {
			System.out.println("Root is null");
			return;
		}
		
		Queue<BinNode> layerQueue = new LinkedList<>();
		layerQueue.add(root);

		ArrayList<LinkedList<BinNode>> result = new ArrayList<>();

		while (!layerQueue.isEmpty()) {
			result.add(new LinkedList<BinNode>(layerQueue));
			Queue<BinNode> buffer = new LinkedList<>();
			while (!layerQueue.isEmpty()) {
				buffer.add(layerQueue.poll());
			}

			while (!buffer.isEmpty()) {
				BinNode curNode = buffer.poll();
				if (curNode.left != null) {
					layerQueue.add(curNode.left);
				}
				if (curNode.right != null) {
					layerQueue.add(curNode.right);
				}
			}
		}

		int layerNo = 0;
		for (LinkedList<BinNode> queue : result) {
			System.out.println("Layer " + layerNo++);
			for (BinNode node : queue) {
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}

	public static boolean isBST(BinNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST(BinNode root, int left, int right) {
		if (root == null) {
			return true;
		}

		return	(root.val <= right && root.val > left) &&
				isBST(root.left, left, root.val) &&
				isBST(root.right, root.val, right);
	}

	/**
	 * Given that those nodes are not null
	 * Node0 is smaller than Node1 and they both belongs to a tree
	 * O(h): h is the height of the tree
	 */
	public static int lowestCommonAncestor(int node0,
			int node1, BinNode root) {

		while (!(root.val >= node0 && root.val < node1)) {
			if (root.val >= node0) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root.val;
	}

	/**
	 * Given a vertex in a binary search tree, find the next node (in-order)
	 * Time: O(n)
	 */
	public static BinNode nextInOrder(BinNode node) {
		if (node.hasRight()) {
			return node.nearestRightChild();
		}

		if (node.isRightChild()) {
			return node.nearestRightParent();
		}

		return node.parent;
	}
}

class BinNode {
	int val;
	BinNode parent;
	BinNode left;
	BinNode right;

	public BinNode(int val) {
		this.val= val;
	}

	public void addRight(BinNode node) {
		this.right = node;
		node.parent = this;
	}

	public void addLeft(BinNode node) {
		this.left = node;
		node.parent = this;
	}

	public boolean hasLeft() {
		return this.left != null;
	}

	public boolean hasRight() {
		return this.right != null;
	}

	public boolean isRightChild() {
		if (this == null || this.parent == null) {
			return false;
		}

		return (this.parent.right == this);
	}

	public BinNode nearestRightChild() {
		if (this == null || !this.hasRight()) {
			return null;
		}

		BinNode iterator = this.right;

		while (iterator.hasLeft()) {
			iterator = iterator.left;
		}

		return iterator;
	}

	public BinNode nearestRightParent() {
		if (this == null || this.parent == null) {
			return null;
		}

		BinNode iterator = this;
		while (iterator.isRightChild()) {
			iterator = iterator.parent;
		}

		return iterator.parent;
	}

	public String toString() {
		return Integer.toString(this.val);
	}

	/**
	 * Check if a binary tree is a subtree of another
	 * Assume that this and bigRoot is not null
	 * Time: O(n^2) ; Space: O(n)
	 */
	public boolean isSubTree(BinNode bigRoot) {
		Queue<BinNode> queue = new LinkedList<>();

		queue.add(bigRoot);
		while (!queue.isEmpty()) {
			BinNode current = queue.poll();
			if (this.isIdentical(current)) {
				return true;
			}
			if (current.hasLeft()) {
				queue.add(current.left);
			}
			if (current.hasRight()) {
				queue.add(current.right);
			}
		}

		return false;
	}

	/**
	 * Check if two trees share the same structure
	 * O(n)
	 */
	public boolean isIdentical(BinNode compare) {
		if (this == null || compare == null) {
			return true;
		}

		boolean cur = this.val == compare.val;
		boolean left = true;
		if (this.left != null) {
			left = this.left.isIdentical(compare.left);
		}
		boolean right = true;
		if (this.right != null) {
			right = this.right.isIdentical(compare.right);
		}

		return cur && left && right;
	}
}

class DirectedGraph {
	private int size;
	private ArrayList<HashSet<Integer>> data;

	public DirectedGraph(int size) {
		this.size = size;
		data = new ArrayList<>();
		for (int i = 0; i < size; ++i) {
			data.add(new HashSet<Integer>());
		}
	}
	/**
	 * O(1) amortized time
	 */
	public void addVertex() {
		data.add(new HashSet<Integer>());
	}

	/**
	 * O(1)
	 */
	public void addEdge(int src, int dest) {
		data.get(src).add(dest);
	}

	/**
	 * O(1)
	 */
	public boolean isConnected(int src, int dest) {
		return data.get(src).contains(dest);
	}

	public void dump() {
		for (int i = 0; i < data.size(); ++i) {
			System.out.print("Node: " + i + ": ");
			for (int it : data.get(i)) {
				System.out.print(it + " ");
			}
			System.out.println();
		}
	}

	/**
	 * O(v + e) : all the edges and vertices are checked
	 */
	public boolean isInterConnected(int src, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();

		queue.add(src);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == dest) {
				return true;
			}

			visited.add(cur);

			for (int it : data.get(cur)) {
				if (!visited.contains(it)) {
					queue.add(it);
				}
			}
		}

		return false;
	}

	public int disConnectedComponents() {
		HashSet<Integer> visited = new HashSet<>();
		int result = 0;

		for (int i = 0; i < size; ++i) {
			if (!visited.contains(i)) {
				result += 1;
				DFSMark(i, visited);
			}
		}
		
		return result;
	}

	/**
	 * O(e + v): all nodes and edges are checked
	 */
	private void DFSMark(int node, HashSet<Integer> visited) {
		visited.add(node);
		for (int it : data.get(node)) {
			if (!visited.contains(it)) {
				DFSMark(it, visited);
			}
		}
	}
}
