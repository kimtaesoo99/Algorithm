import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] parent;
	private static int[] subtreeSize;
	
	private static void union(int a, int b) {
		int x = find(a), y = find(b);
		if (x == y) {
			return;
		}
		parent[Math.max(x, y)] = Math.min(x, y);
		subtreeSize[Math.min(x, y)] = subtreeSize[x] + subtreeSize[y];
	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		//Initialize
		parent = new int[N + 1];
		subtreeSize = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			subtreeSize[i] = 1;
		}
		
		//Union
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		System.out.println(subtreeSize[find(1)] - 1);
	}
	
}