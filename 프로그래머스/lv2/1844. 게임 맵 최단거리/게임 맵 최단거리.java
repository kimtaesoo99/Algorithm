import java.util.*;
class Solution {
    static int[][] result;
    public int solution(int[][] maps) {
        result = new int[maps.length][maps[0].length];
        bfs(0,0, maps);
        return result[maps.length-1][maps[0].length-1]!=0?result[maps.length-1][maps[0].length-1]:-1;
    }
    
    public void bfs(int y, int x, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        result[y][x] = 1;
        q.offer(new int[]{y,x});
        
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            for(int i = 0; i < 4; i++){
                int moveY = poll[0] + dy[i];
                int moveX = poll[1] + dx[i];
                
                if(0<=moveY && moveY < maps.length && 0<= moveX && moveX <maps[0].length){
                    if(maps[moveY][moveX]==1 && result[moveY][moveX] ==0){
                        result[moveY][moveX] = result[poll[0]][poll[1]] +1;
                        q.offer(new int[]{moveY,moveX});
                    }
                }
            }
        }
        
    }
}