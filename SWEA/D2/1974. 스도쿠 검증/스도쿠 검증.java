import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] map = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case + " " + (hasDuplicate(map) ? 1 : 0));
        }
    }

    private static boolean hasDuplicate(int[][] map) {
        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                if (list.contains(map[i][j])) {
                    return false;
                }
                list.add(map[i][j]);
            }

            list = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                if (list.contains(map[j][i])) {
                    return false;
                }
                list.add(map[j][i]);
            }
        }

        for (int y = 0; y < 9; y += 3) {
            for (int x = 0; x < 9; x += 3) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (list.contains(map[y + i][x + j])) {
                            return false;
                        }
                        list.add(map[y + i][x + j]);
                    }
                }
            }
        }

        return true;
    }
}