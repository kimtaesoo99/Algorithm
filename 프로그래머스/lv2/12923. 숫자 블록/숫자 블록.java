import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

class Solution {
    static int index = 0;

    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        LongStream.rangeClosed(begin, end).forEach(i -> answer[index++] = findDivision((int) i));
        return answer;
    }

    private static int findDivision(int num) {
        if (num == 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i <= 10000000) {
                    return num / i;
                }
            }
        }
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        return 1;
    }
}