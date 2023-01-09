import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> overlap = new ArrayList<>();
        char end = words[0].charAt(0);
        for (int i = 0;i< words.length;i++){
            if (words[i].charAt(0) != end || overlap.contains(words[i])){
                return new int[]{ i%n+1  , i/n +1};
            }
            overlap.add(words[i]);
            end = words[i].charAt(words[i].length()-1);
        }

        return new int[]{0,0};
    }
}