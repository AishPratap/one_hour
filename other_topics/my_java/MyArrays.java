import java.io.*;
import java.util.*;

public class MyArrays {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] data = new int[20];

		for (int i = 0; i < data.length; ++i) {
			data[i] = rand.nextInt(1000);
		}

		/* Print out array */
		System.out.println(Arrays.toString(data));

		/* Sort the array with range */
		Arrays.sort(data, 0, 5);
		System.out.println("Sorted: " + Arrays.toString(data));
	}
}
