
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr, int[][] order) {
        int[] answer = new int[order.length];

        for (int i=0;i<order.length; i++){
            int[] temp =new int[order[i][1]-order[i][0]+1];
            int k=0;
            for (int j = order[i][0]-1; j<order[i][1]; j++){
                temp[k++] = arr[j];
            }
            Arrays.sort(temp);
            answer[i] = temp[order[i][2]-1];

        }

        return answer;
    }
}