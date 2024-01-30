import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int temp = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();

			Arrays.stream(br.readLine().split(" ")).forEach(i -> {
				Integer value = Integer.parseInt(i);
				map.put(value, map.getOrDefault(value, 0) + 1);
			});

			for (int i = 0; i < temp; i++) {
				Integer min = map.firstKey();
				Integer max = map.lastKey();

				remove(min, map);
				remove(max, map);

				map.put(min + 1, map.getOrDefault(min + 1, 0) + 1);
				map.put(max - 1, map.getOrDefault(max - 1, 0) + 1);
			}

			sb.append("#").append(test_case).append(" ").append(map.lastKey() - map.firstKey()).append("\n");
		}

		System.out.println(sb);
	}

	private static void remove(int key, TreeMap<Integer, Integer> map) {
		map.put(key, map.getOrDefault(key, 0) - 1);

		if (map.get(key) == 0) {
			map.remove(key);
		}
	}
}