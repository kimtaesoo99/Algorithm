import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int count;
    private static List<int[]> indexs = new ArrayList<>();
    private static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 0) {
                    count++;
                    indexs.add(new int[]{i, j});
                }
            }
        }

        back(0, map);
    }

    private static void back(int index, int[][] map) {
        if (find) {
            return;
        }
        if (index == count) {
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            find = true;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int y = indexs.get(index)[0];
            int x = indexs.get(index)[1];

            if (checkValue(i, y, x, map)){
                map[y][x] = i;
                back(index + 1, map);
                map[y][x] = 0;
            }
        }
    }

    private static boolean checkValue(int value, int y, int x, int[][] map) {
        for (int i = 0; i < 9; i++){
            if (map[i][x] == value){
                return false;
            }
        }

        for (int i = 0; i < 9; i++){
            if (map[y][i] == value){
                return false;
            }
        }

        int startY = y / 3 * 3;
        int startX = x / 3 * 3;

        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++){
                if (map[i][j] ==value){
                    return false;
                }
            }
        }
        return true;
    }
}