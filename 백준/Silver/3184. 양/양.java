import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static char[][] map;
    static boolean[][] visited;
    static int r;
    static int c;
    static int vCount = 0;
    static int oCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++){
            String info = sc.next();
            for (int j = 0 ; j < c; j++){
                map[i][j] = info.charAt(j);
            }
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (map[i][j]!='#' && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        System.out.println(oCount+" " + vCount);
    }

    private static void bfs(int y, int x){
        int v = 0;
        int o = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        if (map[y][x] == 'v')v++;
        if (map[y][x] == 'o')o++;
        visited[y][x] = true;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        while (!q.isEmpty()){
            int[] move = q.poll();
            for (int i = 0; i < 4; i++){
                int moveY = dy[i] + move[0];
                int moveX = dx[i] + move[1];

                if (0<= moveY && moveY <r && 0<= moveX && moveX <c){
                    if (map[moveY][moveX]!='#' && !visited[moveY][moveX]){
                        visited[moveY][moveX] = true;
                        q.offer(new int[]{moveY,moveX});
                        if (map[moveY][moveX]=='v')v++;
                        if (map[moveY][moveX]=='o')o++;
                    }
                }
            }
        }
        if (o>v)oCount +=o;
        else vCount += v;
    }
}
