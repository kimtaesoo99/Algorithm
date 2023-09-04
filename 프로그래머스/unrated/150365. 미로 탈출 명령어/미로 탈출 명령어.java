public class Solution {
    private final String[] dirName = {"d", "l", "r", "u"};
    private final int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    private StringBuilder answer;
    private String result;
    private int endRow;
    private int endCol;
    private int mapRow;
    private int mapCol;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        result = null;
        answer = new StringBuilder();
        mapRow = n;
        mapCol = m;
        endRow = r;
        endCol = c;

        int distance = distance(x, y);

        if (distance > k || (k - distance) % 2 == 1) {
            return "impossible";
        }
        dfs(x, y, 0, k);

        return result != null ? result : "impossible";
    }

    private int distance(int x, int y) {
        return Math.abs(x - endRow) + Math.abs(y - endCol);
    }

    private void dfs(int row, int col, int depth, int limit) {
        if (result != null) {
            return;
        }
        if (depth + distance(row, col) > limit) {
            return;
        }
        if (limit == depth) {
            if (row == endRow && col == endCol) {
                result = answer.toString();
            }
            return;
        }
        for (int i = 0; i < dir.length; i++) {
            int nRow = row + dir[i][0];
            int nCol = col + dir[i][1];
            if (nRow > 0 && nCol > 0 && nRow <= mapRow && nCol <= mapCol) {
                answer.append(dirName[i]);
                dfs(nRow, nCol, depth + 1, limit);
                answer.delete(depth, depth + 1);
            }
        }
    }
}