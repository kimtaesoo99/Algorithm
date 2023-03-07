import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> aList = Arrays.stream(A).boxed().sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
         List<Integer> bList = Arrays.stream(B).boxed().sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
         int j = 0;
         for (int i = 0; i < aList.size(); i++){
            if (bList.get(j) > aList.get(i)){
                answer++;
                j++;
            }
         }
        return answer;
    }
}
