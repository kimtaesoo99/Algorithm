class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            long dis = (long) d * d;
            long x = (long) i * i;
            int y = (int) Math.sqrt(dis - x);
            answer += (y / k) + 1;
        }
        return answer;
    }
}