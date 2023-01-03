import java.util.Arrays;

class Solution {
    public int[] solution(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (max == array[i]) {
                index = i;
                break;
            }
        }
        return new int[]{max,index};
    }
}