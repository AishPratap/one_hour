import java.util.*;

public class Chap03 {
	public static void main(String[] args) throws Exception {
		MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		stack.push(-3);
		stack.push(10);
		stack.pop();
		stack.pop();

		System.out.println(stack.getMin());
		stack.dump();
	}
}

/**
 * Implement a stack using one array of integer
 */
class ArrayStack {
	private int[] array;
	private int top;
	private int size;

	public ArrayStack(int size) {
		this.size = size;
		this.array = new int[size];
		this.top = -1;
	}

	public void push(int val) throws Exception {
		if (top == size - 1) {
			throw new Exception("Stack is full");
		}
		
		array[++top] = val;
	}

	public int pop() throws Exception {
		if (top < 0) {
			throw new Exception("Stack is empty");
		}
		return array[top--];
	}
}

class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty()) {
			minStack.push(val);
		} else {
			minStack.push(Math.min(val, minStack.peek()));
		}
	}

	public int pop() {
		minStack.pop();
		return stack.pop();
	}

	public int getMin() {
		return minStack.peek();
	}

	public void dump() {
		System.out.println(stack);
		System.out.println(minStack);
	}
}

class TripleStack {
	private int[] array;
	private int[] head;
	private int[] tail;
	private int[] top;

	public TripleStack(int size) {
		this.array = new int[3 * size];
		this.head = new int[3];
		this.tail = new int[3];
		this.top = new int[3];
		
		for (int i = 0; i < 3; ++i) {
			this.head[i] = i * size;
			this.tail[i] = (i + 1) * size - 1;
			this.top[i] = this.head[i] - 1;
		}
	}

	public boolean push(int val, int stack) {
		if (stack < 0 || stack > 2) {
			return false;
		}

		if (top[stack] >= tail[stack]) {
			return false;
		}

		array[++top[stack]] = val;
		return true;
	}

	public int pop(int stack) {
		if (stack < 0 || stack > 2) {
			return Integer.MIN_VALUE;
		}

		if (top[stack] < head[stack]) {
			return Integer.MAX_VALUE;
		}

		return array[top[stack]--];
	}

	public void dump() {
		System.out.println(Arrays.toString(array));
	}
}
