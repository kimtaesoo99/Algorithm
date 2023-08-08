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
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //세로
        M = sc.nextInt(); //가로

        map = new String[N][M];
        visited = new boolean[N][M][N][M];
        copyMap = new String[N][M];

        int[] redIndex = new int[2];
        int[] blueIndex = new int[2];

        for (int i = 0; i < N; i++) {
            String[] info = sc.next().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = info[j];
                if (info[j].equals("B")) {
                    blueIndex[0] = i;
                    blueIndex[1] = j;
                    map[i][j] = ".";
                }
                if (info[j].equals("R")) {
                    redIndex[0] = i;
                    redIndex[1] = j;
                    map[i][j] = ".";
                }
            }
        }
        System.out.println(bfs(redIndex, blueIndex));
    }

    private static int bfs(int[] redIndex, int[] blueIndex) {
        Queue<int[]> q = new LinkedList<>();
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
                for (int k = 0; k < map.length; k++) {
                    copyMap[k] = map[k].clone();
                }
                if (i == 0 && redY > blueY) {
                    moveMarble(redY, redX, i, "R");
                    moveMarble(blueY, blueX, i, "B");
                } else if (i == 0) {
                    moveMarble(blueY, blueX, i, "B");
                    moveMarble(redY, redX, i, "R");
                }

                if (i == 1 && redY > blueY) {
                    moveMarble(blueY, blueX, i, "B");
                    moveMarble(redY, redX, i, "R");
                } else if (i == 1) {
                    moveMarble(redY, redX, i, "R");
                    moveMarble(blueY, blueX, i, "B");
                }

                if (i == 2 && redX > blueX) {
                    moveMarble(redY, redX, i, "R");
                    moveMarble(blueY, blueX, i, "B");
                } else if (i == 2) {
                    moveMarble(blueY, blueX, i, "B");
                    moveMarble(redY, redX, i, "R");
                }

                if (i == 3 && redX > blueX) {
                    moveMarble(blueY, blueX, i, "B");
                    moveMarble(redY, redX, i, "R");
                } else if (i == 3) {
                    moveMarble(redY, redX, i, "R");
                    moveMarble(blueY, blueX, i, "B");
                }

                int[] moveRedIndex = new int[2];
                int[] moveBlueIndex = new int[2];

                for (int k = 0; k < N; k++) {
                    for (int j = 0; j < M; j++) {
                        if (copyMap[k][j].equals("B")) {
                            moveBlueIndex[0] = k;
                            moveBlueIndex[1] = j;
                        }
                        if (copyMap[k][j].equals("R")) {
                            moveRedIndex[0] = k;
                            moveRedIndex[1] = j;
                        }
                    }
                }

                if (moveRedIndex[0] == 0 && moveBlueIndex[0] == 0) {
                    continue;
                } else if (moveBlueIndex[0] == 0) {
                    continue;
                } else if (moveRedIndex[0] == 0) {
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

    private static void moveMarble(int y, int x, int moveInfo, String color) {
        while (!(copyMap[y + move[moveInfo][0]][x + move[moveInfo][1]].equals("#") || copyMap[y + move[moveInfo][0]][x
                + move[moveInfo][1]].equals("R") || copyMap[y + move[moveInfo][0]][x + move[moveInfo][1]].equals(
                "B"))) {
            y = y + move[moveInfo][0];
            x = x + move[moveInfo][1];
            if (map[y][x].equals("O")) {
                return;
            }
        }
        copyMap[y][x] = color;
    }
}
