import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			int count = 0;
			char pre = '0';

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != pre) {
					count++;
					pre = str.charAt(i);
				}
			}
			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}