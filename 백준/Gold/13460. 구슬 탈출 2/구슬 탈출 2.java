import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static String[][] map;
    static boolean[][][][] visited;
    static String[][] copyMap;
    static int N;
    static int M;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        init();
        System.out.println(bfs());
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N][M];
        visited = new boolean[N][M][N][M];
        copyMap = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = sc.next().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
            }
        }
    }

    private static int[] findIndex(String target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals(target)) {
                    map[i][j] = ".";
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[] redIndex = findIndex("R");
        int[] blueIndex = findIndex("B");

        q.offer(new int[]{redIndex[0], redIndex[1], blueIndex[0], blueIndex[1], 1});
        visited[redIndex[0]][redIndex[1]][blueIndex[0]][blueIndex[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int redY = now[0];
            int redX = now[1];
            int blueY = now[2];
            int blueX = now[3];
            int count = now[4];

            if (count > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                cloneMap();

                int[] moveRedIndex;
                int[] moveBlueIndex;

                if ((i == 0 && redY > blueY) || (i == 1 && redY <= blueY)) {
                    moveRedIndex = moveMarble(redY, redX, i, "R");
                    moveBlueIndex = moveMarble(blueY, blueX, i, "B");
                } else if ((i == 2 && redX > blueX) || (i == 3 && redX <= blueX)) {
                    moveRedIndex = moveMarble(redY, redX, i, "R");
                    moveBlueIndex = moveMarble(blueY, blueX, i, "B");
                } else {
                    moveBlueIndex = moveMarble(blueY, blueX, i, "B");
                    moveRedIndex = moveMarble(redY, redX, i, "R");
                }

                if (isGameOver(moveBlueIndex)) {
                    continue;
                } else if (isWon(moveRedIndex)) {
                    return count;
                }

                if (!visited[moveRedIndex[0]][moveRedIndex[1]][moveBlueIndex[0]][moveBlueIndex[1]]) {
                    q.offer(new int[]{moveRedIndex[0], moveRedIndex[1], moveBlueIndex[0], moveBlueIndex[1], count + 1});
                    visited[moveRedIndex[0]][moveRedIndex[1]][moveBlueIndex[0]][moveBlueIndex[1]] = true;
                }
            }
        }
        return -1;
    }

    private static void cloneMap() {
        for (int k = 0; k < map.length; k++) {
            copyMap[k] = map[k].clone();
        }
    }

    private static int[] moveMarble(int y, int x, int directionIndex, String color) {
        int dy = move[directionIndex][0];
        int dx = move[directionIndex][1];

        while (isValidMove(y + dy, x + dx)) {
            y += dy;
            x += dx;
            if (map[y][x].equals("O")) {
                return new int[]{0, 0};
            }
        }
        copyMap[y][x] = color;
        return new int[]{y, x};
    }

    private static boolean isValidMove(int y, int x) {
        String cell = copyMap[y][x];
        return (!cell.equals("#") && !cell.equals("R") && !cell.equals("B"));
    }

    private static boolean isGameOver(int[] blueIndex) {
        return blueIndex[0] == 0;
    }

    private static boolean isWon(int[] redIndex) {
        return redIndex[0] == 0;
    }
}
