import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int[][] map = new int[v][v];
        for(int i = 0; i < v; i++)Arrays.fill(map[i],10000000);
        int e = sc.nextInt();
        for(int i = 0 ; i < e; i++){
            map[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();
        }

        for(int i =0 ;i<v; i++){
            for(int j = 0; j< v; j++){
                for(int k = 0 ; k<v;k++){
                    map[i][j] = Math.min(map[i][j],map[i][k] + map[k][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                min = Math.min(min, map[i][j] + map[j][i]);
            }
        }

        System.out.println(min>10000000?-1:min);
    }
}
