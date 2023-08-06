import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int gridSize;
    static int[][] grid;
    static int finalIndex;
    static int result;
    static int boolArraySize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gridSize = Integer.parseInt(br.readLine());
        grid = new int[gridSize][gridSize];
        finalIndex = gridSize * gridSize;
        boolArraySize = gridSize * 2;

        for (int i = 0; i < gridSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalResult = 0;
        for (int i = 0; i < 2; i++) {
            backtrack(new boolean[boolArraySize], new boolean[boolArraySize], i, 0, i);
            totalResult += result;
            result = 0;
        }
        System.out.println(totalResult);
    }

    public static void backtrack(boolean[] first, boolean[] second, int index, int count, int op) {
        if (index >= finalIndex) {
            result = Math.max(result, count);
            return;
        }

        int x = index / gridSize;
        int y = index % gridSize;

        if ((x + y) % 2 == op && grid[x][y] == 1 && !first[x + y] && !second[(x - y + boolArraySize) % boolArraySize]) {
            first[x + y] = true;
            second[(x - y + boolArraySize) % boolArraySize] = true;
            backtrack(first, second, index + 1, count + 1, op);
            first[x + y] = false;
            second[(x - y + boolArraySize) % boolArraySize] = false;
        }
        backtrack(first, second, index + 1, count, op);
    }
}
