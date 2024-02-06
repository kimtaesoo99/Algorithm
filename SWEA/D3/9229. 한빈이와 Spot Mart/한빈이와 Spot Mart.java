import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int left = 0;
			int right = arr.length - 1;

			int result = -1;

			while (left < right) {
				int sum = arr[left] + arr[right];
				
				if(sum > m) {
					right--;
				} else {
					result = Math.max(result, sum);
					left++;
				}
			}
			
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}