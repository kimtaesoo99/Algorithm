class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
            if (sum > n) {
                return sum;
            }
        }
        return sum;
    }
}