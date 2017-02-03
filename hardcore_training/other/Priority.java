import java.util.*;

public class Priority {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of tasks: ");
		int task = scan.nextInt();

		String[] taskList = new String[task];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < task; ++i) {
			String str = scan.next();
			taskList[i] = str;
			map.put(i, 0);
		}

		for (int i = 0; i < task - 1; ++i) {
			for (int j = i + 1; j < task; ++j) {
				System.out.printf("Should %s be done before %s\n", taskList[i], taskList[j]);
				String ans = scan.next();
				if (ans.equals("y")) {
					map.put(i, map.get(i) + 1);
				} else {
					map.put(j, map.get(j) + 1);
				}
			}
		}

		List<Map.Entry<Integer, Integer>> entrySet = new ArrayList<>(map.entrySet());
		System.out.println("debug:entry set: " + entrySet);
	}
}
