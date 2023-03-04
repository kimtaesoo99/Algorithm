import java.util.*;
class Solution {
    static int[][] map = new int[101][101];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] r : rectangle){
            initMap(2*r[0], 2*r[1], 2*r[2], 2*r[3]);
        }
        return bfs(2*characterX, 2*characterY, 2*itemX , 2*itemY)/2;
    }
    
    public void initMap(int x1, int y1, int x2, int y2){
        for(int i = x1; i<=x2; i++){
            for(int j = y1; j<=y2; j++){
                if(map[i][j]==2)continue;
                map[i][j] = 2;
                if(i==x1|| i==x2 || j==y1||j==y2)map[i][j] = 1;
            }
        }
    }
    
    public int bfs(int x,int y , int itemX, int itemY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        int[][] distance = new int[101][101];
        distance[x][y] = 1;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!q.isEmpty()){
            int[] move = q.poll();
            for(int i = 0; i < 4; i++){
                int moveX = move[0] + dx[i];
                int moveY = move[1] + dy[i];
                
                if(validation(moveX,moveY)){
                    if(map[moveX][moveY]==1 && distance[moveX][moveY]==0){
                        distance[moveX][moveY] = distance[move[0]][move[1]]+1;
                        q.offer(new int[]{moveX,moveY});
                    }
                }
            }
        }
        return distance[itemX][itemY];
    }
    
    public boolean validation(int x, int y){
        return (0<= x && x<=100 && 0<=y && y<=100);
    }
}