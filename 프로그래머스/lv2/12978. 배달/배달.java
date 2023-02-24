import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Node>[] nodes;
    static int[] distance;
    public int solution(int N, int[][] road, int K) {
        visited = new boolean[N+1];
        nodes = new ArrayList[N+1];
        distance = new int[N+1];
        for(int i = 1; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
            nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            nodes[from].add(new Node(to,cost));
            nodes[to].add(new Node(from,cost));
        }
        
        findDistance(1);
        int answer = 0;
        for(int i = 1; i <=N; i++){
            if(distance[i]<=K)answer++;
        }


        return answer;
    }
    
    public void findDistance(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        distance[start] = 0;
        
        while(!q.isEmpty()){
            Node nowNode = q.poll();
            int now = nowNode.link;
            visited[now] = true;
            for(Node node : nodes[now]){
                if(!visited[node.link]){
                    if(distance[now]+node.cost < distance[node.link]){
                        distance[node.link] = distance[now] + node.cost;
                        q.offer(new Node(node.link,distance[node.link]));
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
        return this.cost-n.cost;
    }
    
    public Node(int link , int cost){
        this.link = link;
        this.cost = cost;
    }
}