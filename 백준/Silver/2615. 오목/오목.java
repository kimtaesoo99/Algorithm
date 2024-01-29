import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	private static int[][] map;
	private static int result;
	private static int resultY;
	private static int resultX;
	private static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };
	private static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[19][19];

		for (int i = 0; i < 19; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] != 0) {
					check(i, j, map[i][j]);
				}
			}
		}
		System.out.println(result);
		if (result != 0) {
			System.out.println(resultY + " " + resultX);
		}
	}

	private static void check(int y, int x, int value) {
		check1(y, x, value, 0, 1);
		check1(y, x, value, 2, 3);
		check1(y, x, value, 4, 5);
		check1(y, x, value, 6, 7);
	}

	private static void check1(int y, int x, int value, int i, int j) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});

		pq.add(new int[] { y, x });

		int count = 1;
		int moveY = y;
		int moveX = x;

		while (true) {
			moveY += dy[i];
			moveX += dx[i];
			if (!correctIndex(moveY, moveX)) {
				break;
			}
			if (map[moveY][moveX] == value) {
				pq.add(new int[] { moveY, moveX });
				count++;
			} else {
				break;
			}
		}

		moveY = y;
		moveX = x;

		while (true) {
			moveY += dy[j];
			moveX += dx[j];
			if (!correctIndex(moveY, moveX)) {
				break;
			}
			if (map[moveY][moveX] == value) {
				pq.add(new int[] { moveY, moveX });
				count++;
			} else {
				break;
			}
		}

		if (count == 5) {
			result = value;
			int[] yx = pq.poll();
			resultY = yx[0] + 1;
			resultX = yx[1] + 1;
		}
	}

	private static boolean correctIndex(int y, int x) {
		return 0 <= x && x < 19 && 0 <= y && y < 19;
	}
}
