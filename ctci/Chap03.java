import java.util.*;

public class Chap03 {
	public static void main(String[] args) throws Exception {
		SetOfStack stacks = new SetOfStack(5);
		for (int i = 0; i < 37; ++i) {
			stacks.push(i);
		}
		for (int i = 0; i < 5; ++i) {
			stacks.pop(5);
			stacks.pop(6);
		}
		stacks.pop(7);
		stacks.pop();
		stacks.dump();
	}
	/*
	 * Sort a stack so that the largest elements lie on top
	 * You can use only one more stack to do this shit.
	 * Time: O(n^2); Space: O(n)
	 */
	public static void stackSort(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty() || stack.size() == 1) {
			return;
		}

		Stack<Integer> holder = new Stack<>();
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			while (!stack.isEmpty()) {
				int pre = holder.isEmpty() ? Integer.MAX_VALUE : holder.peek();
				int cur = stack.pop();
				if (cur > pre) {
					sorted = false;
					while (!holder.isEmpty()) {
						stack.push(holder.pop());
					}
					stack.push(cur);
				} else {
					holder.push(cur);
				}
			}
		}
		while (!holder.isEmpty()) {
			stack.push(holder.pop());
		}
	}
}

/*/**
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

/**
 * Implement a stack that support push, pop and min in O(1)
 */
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

/**
 * Implement three stacks in one single array
 */
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

/**
 * Implement a queue using two stacks
 */
class MyQueue {
	private Stack<Integer> enqueueStack = new Stack<>();
	private Stack<Integer> dequeueStack = new Stack<>();

	/**
	 * Time: O(n)
	 */
	public void enqueue(int val) {
		if (enqueueStack.isEmpty()) {
			dumpStack(dequeueStack, enqueueStack);
		}
		enqueueStack.push(val);
	}

	/**
	 * Time: O(n)
	 */
	public int dequeue() {
		if (dequeueStack.isEmpty()) {
			dumpStack(enqueueStack, dequeueStack);
		}
		return dequeueStack.pop();
	}

	private void dumpStack(Stack<Integer> from, Stack<Integer> to) {
		while (!from.isEmpty()) {
			to.push(from.pop());
		}
	}
}

class SetOfStack {
	private final int limit;
	private ArrayList<Stack<Integer>> stackList;

	public SetOfStack(int limit) {
		this.limit = limit;
		stackList = new ArrayList<>();
	}

	public void push(int val) {
		if (stackList.isEmpty() || isCurrentStackFull()) {
			stackList.add(new Stack<Integer>());
		}
		
		int lastIndex = stackList.size() - 1;
		Stack<Integer> currentStack = stackList.get(lastIndex);
		currentStack.push(val);
	}

	public int pop() {
		int result = Integer.MIN_VALUE;

		if (stackList.isEmpty()) {
			return Integer.MIN_VALUE;
		}
	
		int lastIndex = stackList.size() - 1;
		if (lastIndex >= 0) {
			Stack<Integer> currentStack = stackList.get(lastIndex);
			result = currentStack.pop();
		}

		shrinkStacks();
		
		return result;
	}
	
	public int pop(int index) {
		int result= Integer.MAX_VALUE;
		if (stackList.isEmpty()) {
			return result;
		}

		int maxIndex = stackList.size() - 1;
		if (index < 0 || index > maxIndex) {
			return result;
		}

		Stack<Integer> currentStack = stackList.get(index);
		result = currentStack.pop();
		shrinkStacks();

		return result;
	}

	public void dump() {
		for (int i = 0; i < stackList.size(); ++i) {
			System.out.println("Stack #" + i + ": ");
			System.out.println(stackList.get(i));
		}
	}

	/**
	 * Given the stackList is not empty or null
	 */
	private boolean isCurrentStackFull() {
		int lastIndex = stackList.size() - 1;
		Stack<Integer> currentStack = stackList.get(lastIndex);
		return currentStack.size() == limit;
	}

	/**
	 * Given the stackList is not empty or null
	 */
	private boolean isLastStackEmpty() {
		int lastIndex = stackList.size() - 1;
		Stack<Integer> currentStack = stackList.get(lastIndex);
		return currentStack.isEmpty();
	}

	/**
	 * Make sure there will be no open and empty stacks
	 */
	private void shrinkStacks() {
		while (isLastStackEmpty()) {
			deleteLastStack();
		}
	}

	private void deleteLastStack() {
		int lastIndex = stackList.size() - 1;
		stackList.remove(lastIndex);
	}
}
