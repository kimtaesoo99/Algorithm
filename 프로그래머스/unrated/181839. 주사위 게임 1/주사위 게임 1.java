class Solution {
    public int solution(int a, int b) {
        int evenCount = getEvenCount(a, b);
        if (evenCount == 2) {
            return Math.abs(a - b);
        }
        if (evenCount == 1) {
            return 2 * (a + b);
        }
        return (int) (Math.pow(a, 2) + Math.pow(b, 2));
    }

    private int getEvenCount(int a, int b) {
        int count = 0;
        if (isEven(a)) {
            count++;
        }
        if (isEven(b)) {
            count++;
        }
        return count;
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }
}