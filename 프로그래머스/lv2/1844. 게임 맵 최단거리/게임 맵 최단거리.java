import java.util.*;
class Solution {
    static int[][] result;
    static int n;
    static int m;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,-1,0,1};
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        result = new int[n][m];
        findDistance(0,0,maps);
        return result[n-1][m-1]==0?-1:result[n-1][m-1];
    }
    
    public void findDistance(int y,int x,int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        result[y][x] =1;
        while(!q.isEmpty()){
            int[] move = q.poll();
            for(int i = 0; i<4; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];
                
                if(0<=moveY && moveY< n && 0<= moveX && moveX <m){
                    if(maps[moveY][moveX]==1 && result[moveY][moveX]==0){
                    result[moveY][moveX] = result[move[0]][move[1]] +1;
                    q.offer(new int[]{moveY,moveX});
                }
                }
            }
        }
    }
}