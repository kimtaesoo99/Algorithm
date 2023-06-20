import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = n; i < num_list.length; i++) {
            list.add(num_list[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(num_list[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}