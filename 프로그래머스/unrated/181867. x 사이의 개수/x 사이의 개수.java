import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                list.add(count);
                count = 0;
            }else count++;
        }
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}