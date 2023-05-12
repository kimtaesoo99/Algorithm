class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        long count;
        for (int i = 1; i <= h; i++) {
            count = (long) w * (h - i) / h;
            if (count == 0) {
                break;
            }
            answer += count;
        }
        return 2 * answer;
    }
}