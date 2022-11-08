
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[] visited;
    static List<Integer>[] graph;
    static int Node;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            result = false;
            Node = Integer.parseInt(st.nextToken());
            visited = new int[Node+1];
            graph = new ArrayList[Node+1];

            for (int j =1;j<=Node;j++){
                graph[j] = new ArrayList<>();
            }
            int edge = Integer.parseInt(st.nextToken());
            for (int j =0;j<edge;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int j =1;j<=Node; j++){
                if (visited[j]==0)DFS(j,1);
            }
            System.out.println(result?"NO":"YES");
        }

    }
    static void DFS(int j, int color){
        visited[j] = color;
        if (result)return;
        for (Integer i : graph[j]){
            if (visited[i]==visited[j]){
                result = true;
                return;
            }
            if (visited[i]==0)DFS(i,color*-1);
        }
    }
}

