import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			int now = arr[i];
			int next = arr[i + 1];
			int next2 = arr[i + 2];

			if (now == 0) {
				continue;
			}

			if (now > 0 && next > 0 && next2 == 0) {
				int division = Math.min(now, next);
				sum += (division * 5);
				sum += (Math.max(now - division, next - division) * 3);
				arr[i] = 0;
				arr[i + 1] = 0;
			} else if (now > 0 && next == 0) {
				sum += (now * 3);
				arr[i] = 0;
			} else if (now > 0 && next > 0 && next2 > 0) {
				if (next < next2) { // ex) 1 4 6
					int division = Math.min(now, next);
					now -= division;
					next -= division;
					next2 -= division;
					sum += (division * 7);
					if (next == 0) { // 가운데가 0이 됨
						sum += (now * 3);
					}
					arr[i] = 0;
					arr[i + 1] = next;
					arr[i + 2] = next2;
				} else { // ex) 3 7 5
					int division = Math.min(now, next - next2);
					sum += (division * 5);
					now -= division;
					next -= division;

					if (now > 0) {
						int remain = Math.min(now, next);
						sum += (remain * 7);
						arr[i] = now - remain;
						arr[i + 1] = next - remain;
						arr[i + 2] = next2 - remain;

						if (arr[i] > 0) {
							sum += (arr[i] * 3);
						}
						arr[i] = 0;

					} else {
						arr[i] = 0;
						arr[i + 1] = next;
					}
				}
			}
		}

		// todo 마지막 분기처리하기

		int last = Math.min(arr[n - 2], arr[n - 1]);
		sum += (last * 5);
		sum += Math.max(arr[n - 2] - last, arr[n - 1] - last) * 3;

		System.out.println(sum);
	}
}