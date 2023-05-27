import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (s1, s2) -> {
                return s1[1] - s2[1];
        });

        int answer = 0;
        int pre = -1;

        for (int[] target : targets) {
            if (pre <= target[0]) {
                pre = target[1];
                answer++;
            }
        }
        return answer;
    }
}