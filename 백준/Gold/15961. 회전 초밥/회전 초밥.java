import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] count = new int[d + 1];

		for (int i = 0; i < k; i++) {
			count[arr[i]]++;
		}
		count[c]++;

		int sum = 0;

		for (int i = 0; i < d + 1; i++) {
			if (count[i] > 0) {
				sum++;
			}
		}

		int result = sum;

		int right = k;
		for (int left = 0; left < n; left++) {
			if (left == 0) {
				count[arr[0]]--;
			} else {
				count[arr[left]]--;
			}

			count[arr[(right++) % n]]++;

			if (count[arr[left]] == 0) {
				result--;
			}
			if (arr[left] != arr[(right - 1) % n] && count[arr[(right - 1) % n]] == 1) {
				result++;
			}

			sum = Math.max(result, sum);
		}

		System.out.println(sum);
	}
}