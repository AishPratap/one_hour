import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String mes =
			"Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
		String sig = "-Atvt :) hrqgse, Cnikg!!";
		String test = "Otjfvknou kskgnl";
		System.out.println(decrypt(mes));
	}

	public static String decrypt(String encrypted_message) {
		int[] key= {8, 2, 5, 1, 2, 2, 0};
		int keySize = key.length;
		StringBuilder origin = new StringBuilder();

		int counter = 0;

		for (int i = 0; i < encrypted_message.length(); ++i) {
			char cur = encrypted_message.charAt(i);

			if (!isLetter(cur)) {
				origin.append(cur);
				continue;
			}

			int shift = key[counter % keySize];
			counter += 1;

			boolean isUp = false;
			if (Character.isUpperCase(cur)) {
				cur -= 'A';
				isUp = true;
			} else {
				cur -= 'a';
			}

			cur = (char) ((cur + 26 - shift) % 26);
			if (isUp) {
				cur += 'A';
			} else {
				cur += 'a';
			}
			origin.append(cur);
		}

		return origin.toString();
	}

	public static boolean isLetter(char c) {
		return	(c >= 'a' && c <= 'z') ||
			(c >= 'A' && c <= 'Z');
	}

	public static int dif(char enc, char org) {
		int d = enc - org;
		if (d < 0) {
			d += 26;
		}

		return d;
	}

	static int findMutationDistance(String start, String end, String[] bank) {
		DNAGraph graph = new DNAGraph(bank);
		return graph.getDistance(start, end);
	}

	
	static  boolean isMutation(String strA, String strB) {
		int dif = 0;
		for (int i = 0; i < strA.length(); ++i) {
			if (strA.charAt(i) != strB.charAt(i)) {
				dif += 1;
			}
		}

		return dif == 1;
	}

	static class DNAGraph {

		public List<List<Integer>> graph;
		public Map<String, Integer> dnaMap;
		public String[] bank;
		public int size;

		public DNAGraph(String[] bank) {
			size = bank.length;
			this.bank = bank;

			dnaMap = new HashMap<>();
			for (int i = 0; i < size; ++i) {
				dnaMap.put(bank[i], i);
			}

			graph = new ArrayList<>();
			for (int i= 0; i < size; ++i) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < size; ++i) {
				for (int j = i + 1; j < size; ++j) {
					if (isMutation(bank[i], bank[j])) {
						connect(i, j);
					}
				}
			}
		}

		private void connect(int a, int b) {
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		private boolean isMutation(String strA, String strB) {
			int dif = 0;
			for (int i = 0; i < strA.length(); ++i) {
				if (strA.charAt(i) != strB.charAt(i)) {
					dif += 1;
				}
			}

			return dif == 1;
		}

		private int getDistance(int a, int b) {
			int dis = -1;

			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[size];

			queue.add(a);

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				visited[cur] = true;

				dis += 1;

				if (cur == b) {
					return dis;
				}

				for (int it : graph.get(cur)) {
					if (!visited[it]) {
						queue.add(it);
					}
				}
			}

			return -1;
		}

		public int getDistance(String strA, String strB) {
			if (!dnaMap.containsKey(strB)) {
				return -1;
			}

			int b = dnaMap.get(strB);

			if (!dnaMap.containsKey(strA)) {
				int minDis = -1;

				for (int i = 0; i < size; ++i) {
					if (isMutation(strA, bank[i])) {
						int temp = getDistance(i, b) + 1;
						if (temp > 0) {
							if (minDis == -1) {
								minDis = temp;
							} else {
								minDis = Math.min(minDis, temp);
							}
						}
					}
					if (minDis == 1) {
						return 1;
					}
				}
				return minDis;
			}

			int a = dnaMap.get(strA);

			return getDistance(a, b);
		}

		//public void dump() {
		//for (List<Integer> it : graph) {
		//System.out.println(it);
		//}
		//}
	}
}

