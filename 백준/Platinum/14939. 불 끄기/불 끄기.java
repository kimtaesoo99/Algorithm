import java.util.Scanner;

public class Main {
    static final int SIZE = 10;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int result = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] map = new boolean[SIZE][SIZE];
        boolean[][] cloneMap = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            String[] line = sc.next().split("");
            for (int j = 0; j < SIZE; j++) {
                if (line[j].equals("O")) {
                    map[i][j] = true;
                }
            }
        }

        for (int c = 0; c < (1 << 10); c++) {
            cloneMap(map, cloneMap);

            int count = 0;
            count = simulation(cloneMap, c, count);

            if (isAllOff(cloneMap)) {
                result = Math.min(result, count);
            }
        }

        System.out.println(result == 101 ? -1 : result);
    }

    private static int simulation(boolean[][] cloneMap, int choose, int count) {
        for (int x = 0; x < SIZE; x++) {
            if ((choose & (1 << x)) != 0) {
                change(cloneMap, 0, x);
                count++;
            }
        }

        for (int y = 1; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (cloneMap[y - 1][x]) {
                    change(cloneMap, y, x);
                    count++;
                }
            }
        }
        return count;
    }

    private static void change(boolean[][] cloneMap, int y, int x) {
        cloneMap[y][x] = turnOff(cloneMap[y][x]);
        for (int dir = 0; dir < 4; dir++) {
            int moveY = y + move[dir][0];
            int moveX = x + move[dir][1];

            if (isCorrectDirection(moveY, moveX)) {
                cloneMap[moveY][moveX] = turnOff(cloneMap[moveY][moveX]);
            }
        }
    }

    private static boolean isAllOff(boolean[][] cloneMap) {
        for (int x = 0; x < SIZE; x++) {
            if (cloneMap[9][x]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrectDirection(int y, int x) {
        return (0 <= y && y < SIZE && 0 <= x && x < SIZE);
    }

    private static boolean turnOff(boolean status) {
        return !status;
    }

    private static void cloneMap(boolean[][] map, boolean[][] cloneMap) {
        for (int i = 0; i < SIZE; i++) {
            cloneMap[i] = map[i].clone();
        }
    }
}
