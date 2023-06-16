import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    n /= i;
                    break;
                }
            }
        }
        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }
}