import java.io.IOException;
import java.util.Scanner;

public class Main{
    //북 , 동, 남 ,서
    static int[] dy ={-1,0,1,0};
    static int[] dx ={0,1,0,-1};
    static int[][] map;
    static int count;
    static int n;
    static int m;
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int startY = sc.nextInt();
        int startX = sc.nextInt();
        int startView = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i<n;i++){
            for (int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(startY,startX,startView);
        System.out.println(count);
    }

    public static void dfs(int y, int x, int view){
        if (map[y][x] == 0){
            map[y][x] = 2;
            count++;
        }
        for (int i = 0 ; i < 4; i++){
            view = (view+3)%4;
            int moveY = y + dy[view];
            int moveX = x + dx[view];

            if (0<= moveY && moveY < n && 0<= moveX && moveX < m){
                if (map[moveY][moveX] == 0){
                    dfs(moveY,moveX,view);
                    return;
                }
            }
        }

        int reverse = (view+2)%4;
        int moveY = y + dy[reverse];
        int moveX = x + dx[reverse];

        if (0<= moveY && moveY < n && 0<= moveX && moveX < m) {
            if (map[moveY][moveX] != 1) {
                dfs(moveY, moveX, view);
            }
        }
    }
}
