import java.util.*;
class Solution {
    static List<Integer>[] nodes;
    static int[] result;
    public int solution(int n, int[][] edge) {
        int answer = 1;
        nodes = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            nodes[i] = new ArrayList<>();
        }
        result = new int[n+1];
        for(int i = 0; i < edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            nodes[from].add(to);
            nodes[to].add(from);
        }
        bfs(1);

        int max = 0;
        for(int i = 1; i <=n; i++){
            if(result[i]>max){
                answer = 1;
                max = result[i];
            }else if(result[i]==max)answer++;
        }
        return answer;
    }
    
    public void bfs(int now){
        Queue<Integer> q = new LinkedList<>();
        q.offer(now);
        result[now] = 1;
        
        while(!q.isEmpty()){
            int nowNode = q.poll();
            
            for(int i=0; i<nodes[nowNode].size(); i++){
                int nextNode = nodes[nowNode].get(i);
                if(result[nextNode] ==0){
                    result[nextNode] = result[nowNode] + 1;
                    q.offer(nextNode);
                }
            }
        }
        
    }
}