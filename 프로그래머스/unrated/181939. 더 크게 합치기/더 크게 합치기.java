class Solution {
    public int solution(int a, int b) {
        int first = Integer.parseInt("" + a + b);
        int second = Integer.parseInt("" + b + a);
        return Math.max(first, second);
    }
}