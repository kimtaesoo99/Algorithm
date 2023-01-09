import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        Object[] array = Arrays.stream(citations)
                .boxed().sorted(Comparator.reverseOrder()).toArray();
        int h = 0;
        for (int i = 0; i< array.length; i++){
            if ((int)array[i]>i)h = i+1;
        }
        return h;
    }
}