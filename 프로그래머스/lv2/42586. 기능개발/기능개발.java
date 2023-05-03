import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        int day = -1;
        for (int i = 0; i < progresses.length; i++) {
            while ((progresses[i] + speeds[i] * day) < 100) {
                day++;
            }
            answer[day]++;
        }
        return Arrays.stream(answer).filter(i -> i != 0).toArray();
    }
}