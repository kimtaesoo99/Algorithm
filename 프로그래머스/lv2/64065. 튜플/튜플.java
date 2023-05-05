import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        String a = s.replace("{", "");
        String[] arr = a.substring(0, a.length() - 2).split("},");
        Arrays.sort(arr, (s1,s2) -> s1.length() - s2.length());
        List<Integer> result = new ArrayList<>();
        for (String str : arr) {
            List<Integer> now = Arrays.stream(str.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            addValue(result, now);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void addValue(List<Integer> result, List<Integer> now) {
        for (Integer r : result) {
            now.remove(r);
        }
        result.add(now.get(0));
    }
}