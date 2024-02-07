import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());

		boolean[][] map = new boolean[100][100];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					map[j][k] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}