import java.util.Scanner;

public class Main {
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        backtrack(0, map);

        System.out.println(result);
    }

    private static void backtrack(int count, int[][] map) {
        if (count == 5) {
            result = Math.max(result, findMax(map));
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] newMap = move(map, dir);
            backtrack(count + 1, newMap);
        }
    }

    private static int findMax(int[][] map) {
        int max = 0;
        for (int[] ints : map) {
            for (int j = 0; j < map.length; j++) {
                max = Math.max(max, ints[j]);
            }
        }
        return max;
    }

    private static int[][] move(int[][] map, int moveIndex) {
        int n = map.length;
        int[][] newMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, n);
        }

        switch (moveIndex) {
            case 0: // UP
                for (int col = 0; col < n; col++) {
                    int availableRow = 0;
                    for (int row = 1; row < n; row++) {
                        if (newMap[row][col] == 0) {
                            continue;
                        }
                        int tile = newMap[row][col];
                        newMap[row][col] = 0;

                        if (newMap[availableRow][col] == tile) {
                            newMap[availableRow][col] = tile * 2;
                            availableRow++;
                        } else if (newMap[availableRow][col] == 0) {
                            newMap[availableRow][col] = tile;
                        } else {
                            newMap[++availableRow][col] = tile;
                        }
                    }
                }
                break;
            case 1: // RIGHT
                for (int row = 0; row < n; row++) {
                    int availableCol = n - 1;
                    for (int col = n - 2; col >= 0; col--) {
                        if (newMap[row][col] == 0) {
                            continue;
                        }
                        int tile = newMap[row][col];
                        newMap[row][col] = 0;

                        if (newMap[row][availableCol] == tile) {
                            newMap[row][availableCol] = tile * 2;
                            availableCol--;
                        } else if (newMap[row][availableCol] == 0) {
                            newMap[row][availableCol] = tile;
                        } else {
                            newMap[row][--availableCol] = tile;
                        }
                    }
                }
                break;
            case 2: // DOWN
                for (int col = 0; col < n; col++) {
                    int availableRow = n - 1;
                    for (int row = n - 2; row >= 0; row--) {
                        if (newMap[row][col] == 0) {
                            continue;
                        }
                        int tile = newMap[row][col];
                        newMap[row][col] = 0;

                        if (newMap[availableRow][col] == tile) {
                            newMap[availableRow][col] = tile * 2;
                            availableRow--;
                        } else if (newMap[availableRow][col] == 0) {
                            newMap[availableRow][col] = tile;
                        } else {
                            newMap[--availableRow][col] = tile;
                        }
                    }
                }
                break;
            case 3: // LEFT
                for (int row = 0; row < n; row++) {
                    int availableCol = 0;
                    for (int col = 1; col < n; col++) {
                        if (newMap[row][col] == 0) {
                            continue;
                        }
                        int tile = newMap[row][col];
                        newMap[row][col] = 0;

                        if (newMap[row][availableCol] == tile) {
                            newMap[row][availableCol] = tile * 2;
                            availableCol++;
                        } else if (newMap[row][availableCol] == 0) {
                            newMap[row][availableCol] = tile;
                        } else {
                            newMap[row][++availableCol] = tile;
                        }
                    }
                }
                break;
        }

        return newMap;
    }
}
