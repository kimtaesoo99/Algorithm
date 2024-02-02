import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	private static List<Character> open = Arrays.asList('(', '[', '{', '<');
	private static List<Character> close = Arrays.asList(')', ']', '}', '>');

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();

			boolean pass = true;

			for (int i = 0; i < n; i++) {
				char now = str.charAt(i);
				int oIndex = open.indexOf(now);
				int cIndex = close.indexOf(now);
				if (oIndex != -1) { // 여는 괄호
					stack.add(now);
				} else if (stack.peek() == open.get(cIndex)) { // 닫는 괄호
					stack.pop();
				} else {
					pass = false;
					break;
				}
			}

			if (!stack.isEmpty()) {
				pass = false;
			}

			sb.append("#").append(test_case).append(" ").append(pass ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}