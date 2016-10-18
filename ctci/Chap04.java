import java.util.*;

public class Chap04 {
	public static void main(String[] args) {
		int[] data = {0,1,2,3,4,5,6,7,8,9};
		BinNode root = generateTree(data);
		System.out.println(isBST(root));
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

	public static void PreOrder(BinNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		PreOrder(root.left);
		PreOrder(root.right);
	}

	public static void InOrder(BinNode root) {
		if (root == null) {
			return;
		}

		InOrder(root.left);
		System.out.print(root.val + " ");
		InOrder(root.right);
	}

	public static void PostOrder(BinNode root) {
		if (root == null) {
			return;
		}

		PostOrder(root.left);
		PostOrder(root.right);
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
}

class BinNode {
	int val;
	BinNode parent;
	BinNode left;
	BinNode right;

	public BinNode(int val) {
		this.val= val;
	}
}
