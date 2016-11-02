import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		//String mes =
		//"Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
		//String sig = "-Atvt :) hrqgse, Cnikg!!";
		//String test = "Otjfvknou kskgnl";
		//System.out.println(decrypt(mes));
		//
		//String seq = "AATTGGCC";
		String[] bank = {
			"GAAAAAAA",
			"AAGAAAAA",
			"AAAAGAAA",
			"GGAAAAAA",
		};

		int a = findMutationDistance("AAAAAAAA", "GGAAAAAA", bank);
		System.out.println(a);
	}

    public static int findMutationDistance(String start, String end, String[] bank) {
        /* Load data to HashSet  */
        Map<String, Integer> path = new HashMap<>();
        for (String word : bank) {
            path.put(word, -1);
        }
        
        //System.out.println("DEBUG:bankSet: " + dataSet);
        
        /* If the end sequence is not there  */
        if (!path.containsKey(end)) {
            return -1;
        }
        
        /* BFS */
        Queue<String> queue = new LinkedList<>();
        int counter = -1;
        
        queue.add(start);
        path.put(start, 0);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
	    //System.out.println("DEBUG:current: " + current);
	    int pathSoFar = path.get(current);
	    path.remove(current);

            if (current.equals(end)) {
		return pathSoFar;
            }
            
            List<String> next = nextWords(current, path);
	     //System.out.println("DEBUG:next: " + next);
            for (String word : next) {
		path.put(word, pathSoFar + 1);
                queue.add(word);
            }
        }
        
        return -1;
    }
    
    public static List<String> nextWords(String current, Map<String, Integer> path) {
        char[] tokens = {'A', 'C', 'T', 'G'};
        List<String> result = new LinkedList<>();
        
        for (int i = 0; i < current.length(); ++i) {
            char[] array = current.toCharArray();
            for (char c : tokens) {
                if (c == array[i]) {
                    continue;
                }
                array[i] = c;
                String str = new String(array);
                if (path.containsKey(str)) {
                    result.add(str);
                }
            }
        }
        
        //System.out.println("DEBUG:path: " + path);
        return result;
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
}

