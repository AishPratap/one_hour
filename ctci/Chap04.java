import java.util.*;

public class Chap04 {
	public static void main(String[] args) {
		BinNode[] nodes = new BinNode[10];
		for (int i = 0; i < 10; ++i) {
			nodes[i] = new BinNode(i);
		}

		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		nodes[1].left = nodes[3];
		nodes[1].right = nodes[4];
		nodes[2].left = nodes[5];
		nodes[4].left = nodes[6];
		nodes[4].right = nodes[7];
		//nodes[7].right = nodes[8];
		//nodes[8].right = nodes[9];
		
		boolean balanced = isBalanced(nodes[0]);
		System.out.println(balanced);
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
