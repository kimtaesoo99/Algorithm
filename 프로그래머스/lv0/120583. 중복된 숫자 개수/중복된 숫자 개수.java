import java.util.Arrays;

class Solution {
    public long solution(int[] array, int n) {
       long result = Arrays.stream(array).filter(i->i==n).count();
        return result;
    }
}