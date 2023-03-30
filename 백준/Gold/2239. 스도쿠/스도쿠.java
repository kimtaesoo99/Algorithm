import java.util.Scanner;

class Main {
    static int[][] map = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            String line = sc.next();
            for (int j = 0; j < 9; j++) {
                map[i][j] = (line.charAt(j) - '0');
            }
        }
        dfs(0, 0);
    }

    private static void dfs(int y, int x) {
        if (x == 9) {
            dfs(y + 1, 0);
            return;
        }

        if (y == 9) {
            print();
            System.exit(0);
        }

        if (map[y][x] == 0) {
            for (int v = 1; v <= 9; v++) {
                if (validation(y, x, v)) {
                    map[y][x] = v;
                    dfs(y, x + 1);
                }
            }
            map[y][x] = 0;
            return;
        }
        dfs(y, x + 1);
    }

    private static boolean validation(int y, int x, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[y][i] == value) {
                return false;
            }
            if (map[i][x] == value) {
                return false;
            }
        }
        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
