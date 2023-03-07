class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int size = land.length;
        int[][] dp = new int[size][4];
        System.arraycopy(land[0], 0, dp[0], 0, 4);

        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][1];
            dp[i][2] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][0], dp[i - 1][3])) + land[i][2];
            dp[i][3] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][0])) + land[i][3];
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[size - 1][i]);
        }

        return answer;
    }
}