import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int[][] map = new int[51][51];
    static int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        for (int i = 1; i <= n; i++){
            String[] info = br.readLine().split("");
            for (int j = 1; j <=m; j++){
                map[i][j] = Integer.parseInt(info[j-1]);
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){

            int zeroCount = 0;

            for (int j = 1; j<=m; j++){
                if (map[i][j] == 0)zeroCount++;
            }

            int samePattern = 0;

            if (zeroCount <= k && zeroCount%2 == k%2){
                for (int j = 1; j<= n; j++){
                    if (isSame(map[i],map[j],m))samePattern++;
                }
            }
            count = Math.max(count, samePattern);
        }
        System.out.println(count);
    }
    public static boolean isSame(int[] arr , int[] arr2,int m){

        for (int i = 1; i<=m; i++){
            if (arr[i] != arr2[i])return false;
        }
        return true;
    }
}
