import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	private static int[] dx = { 0, 0, 1, 0, -1 };
	private static int[] dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			int[] userAMove = new int[m + 1];
			int[] userBMove = new int[m + 1];

			st = new StringTokenizer(br.readLine());
			userAMove[0] = 0;
			for (int i = 1; i <= m; i++) {
				userAMove[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			userBMove[0] = 0;
			for (int i = 1; i <= m; i++) {
				userBMove[i] = Integer.parseInt(st.nextToken());
			}

			BC[] bc = new BC[a];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(bc);

			int userAX = 1;
			int userAY = 1;
			int userBX = 10;
			int userBY = 10;

			int sum = 0;
			int[] visitedInfoA = new int[a];
			int[] visitedInfoB = new int[a];

			for (int i = 0; i <= m; i++) {
				int moveA = userAMove[i];
				int moveB = userBMove[i];

				visitedInfoA = new int[a];
				visitedInfoB = new int[a];

				userAX += dx[moveA];
				userAY += dy[moveA];

				userBX += dx[moveB];
				userBY += dy[moveB];

				int maxA = -1;
				int maxB = -1;

				for (int j = 0; j < a; j++) {
					if (bc[j].inBc(userAX, userAY)) {
						visitedInfoA[j]++;
						if (maxA == -1) {
							maxA = j;
						}
					}
					if (bc[j].inBc(userBX, userBY)) {
						visitedInfoB[j]++;
						if (maxB == -1) {
							maxB = j;
						}
					}
				}

				if (maxA == -1 && maxB == -1) {
					continue;
				}

				if (maxA != maxB) {
					if (maxA != -1) {
						sum += bc[maxA].value;
					}
					if (maxB != -1) {
						sum += bc[maxB].value;
					}
				} else {
					sum += bc[maxA].value;
					for (int j = maxA + 1; j < a; j++) {
						if (visitedInfoA[j] > 0 || visitedInfoB[j] > 0) {
							sum += bc[j].value;
							break;
						}
					}
				}

			}
			sb.append("#").append(test).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}

class BC implements Comparable<BC> {

	int x;
	int y;
	int range;
	int value;

	public BC(int x, int y, int range, int value) {
		this.x = x;
		this.y = y;
		this.range = range;
		this.value = value;
	}

	public boolean inBc(int userX, int userY) {
		return (Math.abs(x - userX) + Math.abs(y - userY)) <= range;
	}

	@Override
	public int compareTo(BC o) {
		return o.value - this.value;
	}
}