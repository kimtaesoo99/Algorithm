class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        for (int i = x; i < y + 1; i++) {
            if (i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            insert(y, dp, i, i * 2);
            insert(y, dp, i, i * 3);
            insert(y, dp, i, i + n);
        }
        return dp[y];
    }

    private static void insert(int y, int[] dp, int i, int a) {
        if (a <= y) {
            dp[a] = (dp[a] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[a]);
        }
    }
}