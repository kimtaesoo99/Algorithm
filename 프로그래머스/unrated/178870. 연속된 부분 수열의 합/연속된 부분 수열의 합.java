import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int start = 0;
        int end = sequence.length;
        int sum = 0;

        for (int L = 0, R = 0; L < sequence.length; L++) {
            while (R < sequence.length && sum < k) {
                sum += sequence[R++];
            }

            if (sum == k) {
                if ((end - start) > R - L - 1) {
                    start = L;
                    end = R - 1;
                }
            }
            sum -= sequence[L];
        }

        return new int[]{start, end};
    }
}