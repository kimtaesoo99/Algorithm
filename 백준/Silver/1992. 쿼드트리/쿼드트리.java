import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++){
            String[] info = br.readLine().split("");
            for (int j = 0 ; j < n; j++){
                map[i][j] = Integer.parseInt(info[j]);
            }
        }

        partition(0,0,n);
        System.out.println(sb);
    }
    public static void partition(int y, int x, int size){
        if (isSameNum(y,x,size)){
            int num = map[y][x];
            if (num ==0)sb.append("0");
            else sb.append("1");
            return;
        }
        int newSize = size/2;
        sb.append("(");
        partition(y,x,newSize);
        partition(y,x+newSize,newSize);
        partition(y+newSize,x,newSize);
        partition(y+newSize,x+newSize,newSize);
        sb.append(")");
    }

    public static boolean isSameNum(int y, int x, int size){
        int num = map[y][x];
        for (int i = y; i < y+size; i++){
            for (int j = x; j < x+size; j++){
                if (map[i][j] != num)return false;
            }
        }
        return true;
    }
}

