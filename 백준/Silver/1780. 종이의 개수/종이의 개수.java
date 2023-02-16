import java.io.*;

public class Main {
    static int[][] map;
    static int count0 = 0;
    static int count1 = 0;
    static int count_1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(info[j]);
            }
        }

        partition(0, 0, n);
        System.out.println(count_1);
        System.out.println(count0);
        System.out.println(count1);
    }

    public static void partition(int y, int x, int size) {
        if (isSameNum(y, x, size)) {
            int num = map[y][x];
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count_1++;

            return;
        }

        int newSize = size / 3;

        partition(y, x, newSize);
        partition(y, x + newSize, newSize);
        partition(y, x + 2 * newSize, newSize);

        partition(y + newSize, x, newSize);
        partition(y + newSize, x + newSize, newSize);
        partition(y + newSize, x + 2 * newSize, newSize);

        partition(y + 2 * newSize, x, newSize);
        partition(y + 2 * newSize, x + newSize, newSize);
        partition(y + 2 * newSize, x + 2 * newSize, newSize);
    }

    private static boolean isSameNum(int y, int x, int size) {
        int num = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
