import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int[][] map;
    static Set<String> set = new HashSet<>();
    static int[] dy = {0,1,-1,0};
    static int[] dx = {1,0,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                dfs(i,j,0,String.valueOf(map[i][j]));
            }
        }
        System.out.println(set.size());
    }

    static void dfs(int y, int x ,int count,String result){
        if (count==5){
            set.add(result);
            return;
        }

        for (int i =0 ; i< 4; i++){
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (0<= moveX && moveX <5 && 0<=moveY && moveY <5){
                dfs(moveY,moveX,count+1, result+map[moveY][moveX]);
            }
        }

    }
}
