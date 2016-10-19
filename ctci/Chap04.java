import java.util.*;

public class Chap04 {
	public static void main(String[] args) {
		int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinNode root = generateTree(data);
		System.out.println(lowestCommonAncestor(3, 6, root));
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
		midNode.left = leftNode;
		midNode.right = rightNode;

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
		this.parent = this;
	}

	public void addLeft(BinNode node) {
		this.left = node;
		this.parent = this;
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
