import java.util.*;
class Solution {
    static List<Node>[] nodes;
    static boolean[] visited;
    static int[] distance;
    public int solution(int N, int[][] road, int K) {
        nodes = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        
        for(int i = 0; i <=N; i++){
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        
        for(int[] i : road){
            int from  = i[0];
            int to = i[1];
            int cost = i[2];
            nodes[from].add(new Node(to,cost));
            nodes[to].add(new Node(from,cost));
        }
        
        dij(1);   
        int answer = 0;
        for(int i =1; i <=N; i++){
            if(distance[i]<=K)answer++;
        }
        
        return answer;
    }
    
    public void dij(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        distance[start] = 0;
        
        while(!q.isEmpty()){
            Node nowNode = q.poll();
            int now = nowNode.link;
            visited[now] = true;
            
            for(Node node : nodes[now]){
                if(!visited[node.link]){
                    if(distance[now] + node.cost < distance[node.link]){
                        distance[node.link] = distance[now] + node.cost;
                        q.offer(new Node(node.link, distance[node.link]));
                    }
                }
            }
        }
    }
}


class Node implements Comparable<Node>{
    int link;
    int cost;
    
    @Override
    public int compareTo(Node n){
        return this.cost - n.cost;
    }
    
    
    public Node(int link, int cost){
        this.link = link;
        this.cost = cost;
    }
}