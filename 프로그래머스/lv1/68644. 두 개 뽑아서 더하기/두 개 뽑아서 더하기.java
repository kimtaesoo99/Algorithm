


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                if (i==j)continue;
                hashSet.add(numbers[i]+numbers[j]);
            }
        }
        Iterator iterator = hashSet.iterator();
        int[] answer = new int[hashSet.size()];
        int k=0;
        while (iterator.hasNext()){
            answer[k++] = (int) iterator.next();
        }
        Arrays.sort(answer);
        return answer;
    }
}