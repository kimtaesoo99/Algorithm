import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static int[][] result;
    static char[][] map;
    static int[] dy ={1,0,-1,0};
    static int[] dx ={0,-1,0,1};
    static int N;
    static int M;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //세로
        M = sc.nextInt(); //가로
        map = new char[N][M];
        for (int i = 0; i < N; i++){
            String line = sc.next();
            for (int j = 0; j < M; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] =='L'){
                    result = new int[N][M];
                    getResult(i,j);
                }
            }
        }
        System.out.println(max);
    }

    static void getResult(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        result[y][x] = 1;

        while (!queue.isEmpty()) {
            int[] move = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (0<=moveY && moveY <N && 0<=moveX && moveX <M){
                    if (map[moveY][moveX]=='L' && result[moveY][moveX]==0){
                        queue.add(new int[]{moveY, moveX});
                        result[moveY][moveX] = result[move[0]][move[1]]+1;
                        max = Math.max(max, result[moveY][moveX]-1);
                    }
                }
            }
        }
    }
}
