class Solution {
    public int solution(int balls, int share) {
        return combination(balls, share);
    }

    private int combination(int n, int m) {
        if (m == 0 || n == m) {
            return 1;
        }
        return combination(n - 1, m - 1) + combination(n - 1, m);
    }
}