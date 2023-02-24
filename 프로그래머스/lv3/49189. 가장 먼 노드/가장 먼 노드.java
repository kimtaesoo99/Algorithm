import java.util.*;
class Solution {
    static List<Integer>[] nodes;
    static int[] distance;
    public int solution(int n, int[][] edge) {
        nodes = new ArrayList[n+1];
        distance = new int[n+1];
        for(int i =1 ; i <=n; i++)nodes[i] = new ArrayList<>();
        
        for(int i = 0 ; i < edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        bfs(1);
        int count = 0;
        int maxDistance = 0;
        for(int i =1; i<=n;i++){
            if(maxDistance<distance[i]){
                maxDistance = distance[i];
                count = 1;
            }
            else if(maxDistance==distance[i])count++;
        }
        
        return count;
    }
    
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : nodes[now]){
                if(distance[next]==0){
                    distance[next] = distance[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}