import java.util.*;
class Solution {
    static List<Integer>[] nodes;
    static int[] distance;
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        nodes = new ArrayList[n+1];
        distance = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++)nodes[i] = new ArrayList<>();
        
        for(int[] e : edge){
            int from = e[0];
            int to = e[1];
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        bfs(1);
        int count = 0;
        int max = 0;
        for(int i =1 ; i<=n; i++){
            if(distance[i] > max){
                max = distance[i];
                count = 1;
            }else if(distance[i] == max){
                count++;
            }
        }
        
        
        return count;
    }
    
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 1;
        while(!q.isEmpty()){
            int next = q.poll();
            for(int node : nodes[next]){
                if(!visited[node] && distance[node]==0){
                    distance[node] = distance[next] + 1;
                    visited[node] = true;
                    q.offer(node);
                }
            }
        }
    }
}