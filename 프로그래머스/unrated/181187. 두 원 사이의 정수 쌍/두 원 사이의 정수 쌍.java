class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            int max = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            int min = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            answer += max - min + 1;
        }
        return answer * 4;
    }
}