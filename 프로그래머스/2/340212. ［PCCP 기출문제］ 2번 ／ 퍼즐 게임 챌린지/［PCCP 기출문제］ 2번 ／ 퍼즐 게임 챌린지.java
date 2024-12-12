import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = Arrays.stream(diffs).max().orElse(1);

        while (left < right) {
            long mid = (left + right) / 2;

            if (can(mid, diffs, times, limit)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) right;
    }

    private boolean can(long mid, int[] diffs, int[] times, long limit) {
        long sum = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= mid) {
                sum += times[i];
            } else {
                long gap = diffs[i] - mid;

                if (i == 0) {
                    sum += times[i] * (gap + 1);
                } else {
                    sum += (times[i] + times[i - 1]) * gap + times[i];
                }
            }

            if (sum > limit) {
                return false;
            }
        }

        return true;
    }
}
