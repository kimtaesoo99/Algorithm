
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int[][] map;
    static int[][] result;
    static int[] dy = {-2,-2,0,0,2,2};
    static int[] dx = {-1,1,-2,2,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        result = new int[n][n];
        int y = sc.nextInt();
        int x = sc.nextInt();

        bfs(y,x);

        System.out.println(result[sc.nextInt()][sc.nextInt()] -1);
    }
    public static void bfs(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        result[y][x] = 1;

        while (!queue.isEmpty()){
            int[] move = queue.poll();

            for (int i =0; i< 6; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (0<=moveY && moveY< result.length && 0<=moveX && moveX < result.length){
                    if (result[moveY][moveX] ==0){
                        result[moveY][moveX] = result[move[0]][move[1]]+1;
                        queue.add(new int[]{moveY, moveX});
                    }
                }
            }
        }
    }
}
