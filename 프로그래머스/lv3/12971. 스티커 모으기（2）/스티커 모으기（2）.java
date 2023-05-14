import java.util.Arrays;

class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n <= 2) {
            return Arrays.stream(sticker).max().orElse(0);
        }
        int[] firstStart = new int[n - 1];
        int[] secondStart = new int[n];

        firstStart[0] = sticker[0];
        firstStart[1] = sticker[0];

        secondStart[0] = 0;
        secondStart[1] = sticker[1];

        for (int i = 2; i < n; i++) {
            secondStart[i] = Math.max(secondStart[i - 2] + sticker[i], secondStart[i - 1]);
            if (i == n - 1) {
                break;
            }
            firstStart[i] = Math.max(firstStart[i - 2] + sticker[i], firstStart[i - 1]);
        }
        return Math.max(firstStart[n - 2], secondStart[n - 1]);
    }
}