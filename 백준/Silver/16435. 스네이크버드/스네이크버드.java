import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] foods = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			foods[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(foods);

		if (foods[0] > l) {
			System.out.println(l);
			System.exit(0);
		}

		int index = 0;
		int pre = 0;

		while (true) {
			index = binarySearch(-1, foods.length, l, foods);
			l += index - pre;
			
			if (pre == index) {
				break;
			}
			
			pre = index;

			if (index >= foods.length || foods[index] > l) {
				break;
			}
		}

		System.out.println(l);
	}

	private static int binarySearch(int left, int right, int key, int[] foods) {
		int low = left;
		int high = right;

		while (low + 1 < high) {
			int mid = (low + high) >> 1;
			int midVal = foods[mid];

			if (midVal <= key)
				low = mid;
			else
				high = mid;
		}
		return high;
	}
}