class Solution {
    public int solution(int a, int b, int n) {
        int count = 0;
        while (true) {
            if (n < a) break;
            
            count += (n / a) * b;
            int remain = n % a;
            n = (n / a) * b + remain;
        }
        return count;
    }
}