import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	private static StringBuilder sb;
	private static int[][] arr;
	private static int now;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}

		back(0, 0, n);
		System.out.println(sb);
	}

	private static void back(int startY, int startX, int size) {
		if (isSameTree(startY, startX, size)) {
			sb.append(now);
			return;
		}

		int nextSize = size / 2;
		sb.append("(");
		back(startY, startX, nextSize);
		back(startY, startX + nextSize, nextSize);
		back(startY + nextSize, startX, nextSize);
		back(startY + nextSize, startX + nextSize, nextSize);
		sb.append(")");
	}

	private static boolean isSameTree(int startY, int startX, int size) {
		int pre = arr[startY][startX];

		for (int i = startY; i < startY + size; i++) {
			for (int j = startX; j < startX + size; j++) {
				if (arr[i][j] != pre) {
					return false;
				}
			}
		}

		now = arr[startY][startX];

		return true;
	}
}