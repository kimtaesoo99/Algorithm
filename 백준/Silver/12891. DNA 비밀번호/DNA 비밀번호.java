import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static List<Character> word = Arrays.asList('A', 'C', 'G', 'T');
	private static Integer[] count = new Integer[4];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < p; i++) {
			count[word.indexOf(str.charAt(i))]--;
		}

		int left = 0;
		int right = p;
		int result = canPassword() ? 1 : 0;

		while (right < s) {
			count[word.indexOf(str.charAt(left++))]++;
			count[word.indexOf(str.charAt(right++))]--;
			if (canPassword()) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static boolean canPassword() {
		return word.stream().allMatch(i -> count[word.indexOf(i)] <= 0);
	}
}