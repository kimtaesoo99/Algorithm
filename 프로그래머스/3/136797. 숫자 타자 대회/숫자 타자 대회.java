import java.util.*;

class Solution {
    private int[][] cost;
    private int[][][] dp;
    private int length;
    private String nums;

    public int solution(String numbers) {
        initCost();

        length = numbers.length();
        nums = numbers;
        dp = new int[length][10][10];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 4, 6);

    }

    public int solve(int idx, int left, int right) {
        if (idx == length) {
            return 0;
        }
        if (dp[idx][left][right] != -1) {
            return dp[idx][left][right];
        }

        int num = nums.charAt(idx) - '0';
        int ans = Integer.MAX_VALUE;

        if (num != right) {
            ans = Math.min(solve(idx + 1, num, right) + cost[left][num], ans);
        }

        if (num != left) {
            ans = Math.min(solve(idx + 1, left, num) + cost[right][num], ans);
        }

        return dp[idx][left][right] = ans;
    }

    public void initCost() {
        cost = new int[10][10];

        int r1;
        int c1;
        int r2;
        int c2;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    cost[i][j] = 1;
                    continue;
                }

                if (i == 0) {
                    r1 = 3;
                    c1 = 1;
                } else {
                    r1 = (i - 1) / 3;
                    c1 = (i - 1) % 3;
                }
                if (j == 0) {
                    r2 = 3;
                    c2 = 1;
                } else {
                    r2 = (j - 1) / 3;
                    c2 = (j - 1) % 3;
                }

                int dr = Math.abs(r1 - r2);
                int dc = Math.abs(c1 - c2);
                int min = Math.min(dr, dc);
                int max = Math.max(dr, dc);
                int diff = dr + dc;

                if (diff == 1) {
                    cost[i][j] = 2;
                } else if (diff > 1) {
                    cost[i][j] = min * 3 + (max - min) * 2;
                }
            }
        }
    }
}