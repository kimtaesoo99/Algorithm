import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int M;
    static int N;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++){
            String info = sc.next();
            for (int j = 0; j < N; j++){
                map[i][j] = info.charAt(j);
            }
        }

        for (int i = 0; i < N; i++){
            if (!visited[0][i] && map[0][i]=='0'){
                bfs(0,i);
            }
        }

        System.out.println(getResult()?"YES":"NO");
    }

    private static void bfs(int y , int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;

        int[] dy = {1,0,-1,0};
        int[] dx = {0,-1,0,1};

        while (!q.isEmpty()){
            int[] move = q.poll();
            for (int i = 0; i < 4; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (0<= moveY && moveY < M && 0<= moveX && moveX <N){
                    if (!visited[moveY][moveX] && map[moveY][moveX]=='0'){
                        visited[moveY][moveX] = true;
                        q.offer(new int[]{moveY,moveX});
                    }
                }
            }
        }
    }

    private static boolean getResult(){
        for (int i = 0; i < N; i++){
            if (visited[M-1][i])return true;
        }
        return false;
    }
}
