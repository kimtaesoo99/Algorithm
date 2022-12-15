import java.util.Arrays;

class Solution {
    public long solution(int n) {
        int[] notPrime = new int[n + 1]; 
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = 2; j * i <= n; j++) {
                notPrime[j * i] = 1;
            }
        }
        return Arrays.stream(notPrime).filter(i ->i==0).count()-2;
    }
}