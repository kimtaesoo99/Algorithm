import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Long> result;

    public List<Long> solution(long[] numbers) {
        result = new ArrayList<>();
        for (long number : numbers) {
            result.add(findResult(number));
        }
        return result;
    }

    private long findResult(long number) {
        if (number % 2 == 0) {
            return number + 1;
        }
        String binary = Long.toBinaryString(number);
        int zeroIndex = binary.lastIndexOf("0");
        String now = "1";

        if (zeroIndex == -1) {
            now += "0".repeat(binary.length() - 1);
        } else {
            now += "0".repeat(binary.length() - zeroIndex - 2);
        }
        return number + Long.parseLong(now, 2);
    }
}