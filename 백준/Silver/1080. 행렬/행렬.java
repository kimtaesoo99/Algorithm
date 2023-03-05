import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        int[][] arr = new int[n][m];
        initMap(br, n, m, arr);
        int[][] target = new int[n][m];
        initMap(br, n, m, target);

        findSize(arr, target);
        boolean same = isSame(arr, target);

        System.out.println(same?count:-1);
    }

    private static void initMap(BufferedReader br, int n, int m, int[][] arr) throws IOException {
        for (int i = 0; i < n; i++){
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static void findSize(int[][] arr, int[][] target){
        for (int i = 0; i <= arr.length-3; i++){
            for (int j = 0; j <= arr[0].length-3; j++){
                if (arr[i][j] != target[i][j]){
                    changeMap(arr,i,j);
                    count++;
                }
            }
        }
    }

    private static void changeMap(int[][] arr , int i, int j){
        for (int y = i; y < i+3; y++){
            for (int x = j; x < j+3; x++){
                if (arr[y][x] ==1)arr[y][x] = 0;
                else arr[y][x] = 1;
            }
        }
    }

    private static boolean isSame(int[][] arr, int[][] target){
        for (int i = 0 ; i < arr.length; i++){
            for (int j = 0; j <arr[0].length; j++){
                if (arr[i][j]!=target[i][j])return false;
            }
        }
        return true;
    }
}
