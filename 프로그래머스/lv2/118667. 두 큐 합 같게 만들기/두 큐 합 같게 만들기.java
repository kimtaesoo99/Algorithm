import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static long firstSum = 0;
    static long secondSum = 0;

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> firstQ = new LinkedList<>();
        Arrays.stream(queue1).forEach(i -> {
            firstQ.add(i);
            firstSum += i;
        });

        Queue<Integer> secondQ = new LinkedList<>();
        Arrays.stream(queue2).forEach(i -> {
            secondQ.add(i);
            secondSum += i;
        });

        for (int i = 0; i < 2 * (queue1.length + queue2.length); i++) {
            if (firstSum == secondSum) {
                return i;
            }
            if (firstSum > secondSum && !firstQ.isEmpty()) {
                int move = firstQ.poll();
                firstSum -= move;
                secondQ.add(move);
                secondSum += move;
            } else if (firstSum < secondSum && !secondQ.isEmpty()) {
                int move = secondQ.poll();
                secondSum -= move;
                firstQ.add(move);
                firstSum += move;
            } else {
                return -1;
            }
        }
        return -1;
    }
}