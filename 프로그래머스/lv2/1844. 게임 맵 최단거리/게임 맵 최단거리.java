import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] result;
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    public int solution(int[][] maps) {
        result = new int[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j<maps[0].length; j++){
                result[i][j] = -1;
            }
        }
        bfs(0,0,maps);

        return result[maps.length-1][maps[0].length-1];
    }
    void bfs(int y, int x ,int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        result[y][x] = 1;

        while (!queue.isEmpty()){
            int[] move = queue.poll();
            for (int i = 0; i < 4; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];
                if (0<= moveX && moveX < maps[0].length && 0<= moveY && moveY <maps.length){
                    if (maps[moveY][moveX] == 1 && result[moveY][moveX]==-1){
                        result[moveY][moveX] = result[move[0]][move[1]] + 1;
                        queue.add(new int[]{moveY, moveX});
                    }
                }
            }
        }
    }
}