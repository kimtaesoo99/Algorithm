import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

	private static int[][] map;
	private static Deque<Integer> d;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		d = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			String command = st.nextToken();
			switch (command) {
			case "1":
				changeUpAndDown();
				break;
			case "2":
				changeLeftAndRight();
				break;
			case "3":
				rotateRight();
				break;
			case "4":
				rotateLeft();
				break;
			case "5":
				moveRight();
				break;
			default:
				moveLeft();
				break;
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void changeUpAndDown() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
		}

		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}
	}

	private static void changeLeftAndRight() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = d.pollFirst();
			}
		}
	}

	private static void rotateRight() {
		for (int j = 0; j < map[0].length; j++) {
			for (int i = map.length - 1; i >= 0; i--) {
				d.offerFirst(map[i][j]);
			}
		}

		map = new int[map[0].length][map.length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}
	}

	private static void rotateLeft() {
		rotateRight();
		rotateRight();
		rotateRight();
	}

	private static void moveRight() {
		// 1
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				d.offerFirst(map[i][j]);
			}
		}
		// 2
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
		}
		// 3
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
		}
		// 4
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				d.offerFirst(map[i][j]);
			}
		}

		// 2
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}

		// 3
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}

		// 4
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				map[i][j] = d.pollLast();
			}
		}

		// 1
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				map[i][j] = d.pollLast();
			}
		}
	}

	private static void moveLeft() {
		moveRight();
		moveRight();
		moveRight();
	}
}