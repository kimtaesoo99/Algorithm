class Solution {

    private static final int INF = 100001;

    private int[][] dp;

    public int[] solution(int target) {
        dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = INF;
        }

        return throwDarts(target);
    }

    private int[] throwDarts(int n) {
        if (dp[n][0] == INF) {
            // 불 맞추기
            if (n >= 50) {
                int[] temp = throwDarts(n - 50);
                updateDartCount(n, 1 + temp[0], 1 + temp[1]);
            }

            int maxScore = Math.min(n, 20);
            for (int i = maxScore; i >= 1; i--) {
                for (int j = 1; j <= 3; j++) {
                    if (n >= i * j) {
                        int[] temp = throwDarts(n - i * j);
                        int count = (j == 1) ? 1 : 0;
                        updateDartCount(n, 1 + temp[0], count + temp[1]);
                    }
                }
            }
        }

        return dp[n];
    }

    private void updateDartCount(int n, int dartCount, int singleBullCount) {
        if ((dartCount < dp[n][0]) || (dartCount == dp[n][0] && singleBullCount > dp[n][1])) {
            dp[n][0] = dartCount;
            dp[n][1] = singleBullCount;
        }
    }
}
