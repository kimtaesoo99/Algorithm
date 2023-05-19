class Solution {
    static int[][] sum;
    static int N, M;

    public static int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;

        sum = new int[N + 1][M + 1];
        for (int[] s : skill) {
            int y1 = s[1];
            int x1 = s[2];
            int y2 = s[3];
            int x2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);

            sum[y1][x1] += degree;
            sum[y1][x2 + 1] -= degree;
            sum[y2 + 1][x1] -= degree;
            sum[y2 + 1][x2 + 1] += degree;
        }
        operate();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + sum[i][j] > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void operate() {
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                sum[y][x] += sum[y - 1][x];
            }
        }
        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
                sum[y][x] += sum[y][x - 1];
            }
        }
    }
}