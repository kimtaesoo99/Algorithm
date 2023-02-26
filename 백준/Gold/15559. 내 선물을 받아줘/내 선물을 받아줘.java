import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int[][] visited;
    static int result;
    static int depth;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        map = new char[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0 ; i < n; i++){
            for (int  j = 0; j < m; j++){
                if (visited[i][j] == 0){
                    depth++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(result);
    }

    public static void dfs(int y, int x){
        visited[y][x] = depth;

        char c = map[y][x];
        int[] next = new int[2];
        if (c=='N')next[0] = -1;
        else if (c == 'E') next[1] = 1;
        else if (c == 'S') next[0] = 1;
        else next[1] = -1;

        int moveY = y + next[0];
        int moveX = x + next[1];

        if (visited[moveY][moveX] == 0){
            dfs(moveY,moveX);
        } else if (visited[moveY][moveX] == depth) {
            result++;
        }
    }
}
