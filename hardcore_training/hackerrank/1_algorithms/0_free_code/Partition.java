import java.util.*;

public class Partition {
	
	public static void main(String[] args) {
		int[] data = {5, 1, 9, 10, 4, 2};
		System.out.println(Arrays.toString(data));
		System.out.println(partition(data, 0, data.length - 1));
		System.out.println(Arrays.toString(data));
	}

	public static int partition(int[] data, int startInd, int endInd) {
		int leftPnt = startInd + 1;
		int rightPnt = endInd;

		while (leftPnt <= rightPnt) {
			while (leftPnt <= endInd && data[leftPnt] <= data[startInd]) {
				leftPnt += 1;
			}
			while (rightPnt >= startInd && data[rightPnt] > data[startInd]) {
				rightPnt -= 1;
			}

			if (leftPnt <= rightPnt) {
				swap(data, leftPnt, rightPnt);
				leftPnt += 1;
				rightPnt -= 1;
			}
		}

		swap(data, startInd, leftPnt - 1);
		return leftPnt - 1;
	}

	public static void swap(int[] data, int ind1, int ind2) {
		int temp = data[ind1];
		data[ind1] = data[ind2];
		data[ind2] = temp;
	}
}
