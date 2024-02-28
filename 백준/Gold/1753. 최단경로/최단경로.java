import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V;
	static int E;
	static int start;
	static List<Node>[] graph;

	static class Node {
		int idx;
		int cost;

		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine()) - 1;
		graph = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, c));
		}

		int[] dist = new int[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

		q.offer(new Node(start, 0));
		dist[start] = 0;

		while (!q.isEmpty()) {
			Node curNode = q.poll();

			if (dist[curNode.idx] < curNode.cost) {
				continue;
			}

			for (Node next : graph[curNode.idx]) {
				if (dist[next.idx] > curNode.cost + next.cost) {
					dist[next.idx] = curNode.cost + next.cost;
					q.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		for (int d : dist) {
			if (d == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(d).append("\n");
			}
		}

		System.out.println(sb);
	}
}