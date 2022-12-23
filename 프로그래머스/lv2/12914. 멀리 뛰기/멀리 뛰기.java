class Solution {
    public long solution(int n) {
        long[] count = new long[n + 1];
        count[1] = 1;
        if (n>=2) {
            count[2] = 2;
            for (int i = 3; i <= n; i++) {
                count[i] = (count[i - 1] + count[i - 2]) % 1234567;
            }
        }
        return count[n];
    }
}