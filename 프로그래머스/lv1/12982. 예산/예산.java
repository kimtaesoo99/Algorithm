
import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for (int i=0;i<d.length;i++){
            budget=budget-d[i];
            if (budget<0)break;
            count++;
        }


        return count;
    }
}

