import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Node>[] nodes;
    static int[] distance;
    static int min;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        nodes = new ArrayList[n+1];
        for(int i =1; i<=n; i++){
            nodes[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < fares.length; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            nodes[from].add(new Node(to,cost));
            nodes[to].add(new Node(from,cost));
        }
        min = Integer.MAX_VALUE;
        
        List<Integer> fromStart = new ArrayList<>();
        List<Integer> fromA = new ArrayList<>();
        List<Integer> fromB = new ArrayList<>();
        findDistance(s,n);
        for(int i = 1; i<=n; i++){
            fromStart.add(distance[i]);
        }
        findDistance(a,n);
        for(int i = 1; i<=n; i++){
            fromA.add(distance[i]);
        }
        findDistance(b,n);
        for(int i = 1; i<=n; i++){
            fromB.add(distance[i]);
        }
        for(int i = 1; i<=n; i++){
            min = Math.min(min,fromStart.get(i-1)+fromA.get(i-1)+fromB.get(i-1));
        }
        
        
        return min;
    }
    
    public void findDistance(int start ,int n){
        visited = new boolean[n+1];
        distance = new int[n+1];
        for(int i =1; i <= n; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        visited[start] = true;
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