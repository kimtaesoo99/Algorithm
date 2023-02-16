import java.io.*;

public class Main {
    static int[][] map;
    static int white = 0; //0
    static int blue = 0; //1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0 ; i < n; i++){
            String[] info = br.readLine().split(" ");
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(info[j]);
            }
        }

        partition(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int y, int x, int size){
        if (isSameColor(y,x,size)){
            int color = map[y][x];
            if (color==0)white++;
            else blue++;
            return;
        }

        int newSize = size/2;

        partition(y,x,newSize);
        partition(y,x+newSize,newSize);

        partition(y+newSize,x,newSize);
        partition(y+newSize,x+newSize,newSize);

    }

    private static boolean isSameColor(int y, int x, int size) {
        int color = map[y][x];
        for (int i = y ; i < y+size; i++){
            for (int j = x; j< x+ size; j++){
                if (color!=map[i][j])return false;
            }
        }
        return true;
    }


}
