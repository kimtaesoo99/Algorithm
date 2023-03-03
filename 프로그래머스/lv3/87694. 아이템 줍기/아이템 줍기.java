import java.util.*;
class Solution {
    static int[][] map;
    static int[][] distance;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        map = new int[101][101];
        distance = new int[101][101];
        initMap(rectangle);
        bfs(2*characterX, 2*characterY);
        return distance[2*itemY][2*itemX]/2;
    }
    
    public void initMap(int[][] rectangle){
        for(int[] r : rectangle){
            int x1 = 2*r[0];
            int y1 = 2*r[1];
            int x2 = 2*r[2];
            int y2 = 2*r[3];
            
            for(int i = y1; i<=y2; i++){
                for(int j = x1; j<=x2; j++){
                    if(map[i][j]==2)continue;
                    map[i][j] = 2;
                    if(i==y1 || i == y2|| j==x1||j==x2)map[i][j] = 1;
                }
            }
        }
    }
    
    public void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        distance[y][x] = 1;
        q.offer(new int[]{y,x});
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] move = q.poll();
            for(int i = 0 ; i <4; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];
                
                if(0<= moveX && moveX <=100 && 0<=moveY && moveY <=100){
                    if(map[moveY][moveX] == 1 && distance[moveY][moveX] ==0){
                        distance[moveY][moveX] = distance[move[0]][move[1]]+1;
                        q.offer(new int[]{moveY,moveX});
                    }
                }
            }
        }
        
    }
}