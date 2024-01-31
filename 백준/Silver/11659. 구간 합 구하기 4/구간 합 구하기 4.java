import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] sum = new int[n + 1];
		int now = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			now += Integer.parseInt(st.nextToken());
			sum[i] = now;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) ;
			sb.append(sum[to] - sum[from]).append("\n");
		}
	
		System.out.println(sb);
	}
}