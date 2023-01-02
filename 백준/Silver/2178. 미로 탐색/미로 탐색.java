
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static String[][] map;
    static int[][] count;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new String[n][m];
        count = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] a = sc.next().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = (a[j]);
            }
        }
        bfs(0,0);
        System.out.println(count[n-1][m-1]);
    }
    static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{y,x});
        count[y][x] = 1;
        while (!queue.isEmpty()){
            int[] move = queue.poll();

            for (int i = 0; i < 4; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];
                if (0<=moveX && moveX <m && 0<=moveY && moveY <n){
                    if (count[moveY][moveX] == 0 && map[moveY][moveX].equals("1")){
                        count[moveY][moveX] = count[move[0]][move[1]] + 1;
                        queue.offer(new int[]{moveY,moveX});
                    }
                }
            }
        }
    }
}
