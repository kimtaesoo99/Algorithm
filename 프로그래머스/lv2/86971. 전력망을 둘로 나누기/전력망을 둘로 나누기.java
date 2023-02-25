import java.util.*;
class Solution {
    static int[][] map;
    static int answer;
    public int solution(int n, int[][] wires) {
        map = new int[n+1][n+1];
        answer = n;
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a][b] = 0;
            map[b][a] = 0;
            
            bfs(n,i+1);
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        return answer;
    }
    
    public void bfs(int n, int start){
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 1; i <= n; i++){
                if(map[now][i]==1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        answer = Math.min(answer, Math.abs(n-2*count));
    }
}