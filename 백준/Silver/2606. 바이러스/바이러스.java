import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] nodes = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		int v = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			nodes[from].add(to);
			nodes[to].add(from);
		}
		
		boolean[] visited = new boolean[n];
		
		back(0, nodes, visited);
		
		int count = -1;
		visited[0] = true;
		for(int i = 0; i < n; i++){
			if(visited[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static void back(int now, List<Integer>[] nodes, boolean[] visited) {
		for(int next : nodes[now]) {
			if(!visited[next]) {
				visited[next]= true;
				back(next, nodes, visited);
			}
		}
	}
}