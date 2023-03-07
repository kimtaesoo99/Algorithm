import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    static int j = 0;
    static int answer = 0;
    public int solution(int[] A, int[] B) {

        List<Integer> bList = Arrays.stream(B).boxed().sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

         Arrays.stream(A).boxed().sorted(Collections.reverseOrder())
                 .forEach(i -> {
                     if (i < bList.get(j)){
                        j++;
                        answer++;
                     }
                 });
        return answer;
    }
}