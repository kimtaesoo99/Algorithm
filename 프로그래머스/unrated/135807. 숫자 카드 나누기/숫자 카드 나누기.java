class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        if (!compareArr(arrayA, gcdB)) {
            gcdB = 0;
        }
        if (!compareArr(arrayB, gcdA)) {
            gcdA = 0;
        }
        return Math.max(gcdA, gcdB);
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    private boolean compareArr(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % num == 0) {
                return false;
            }
        }
        return true;
    }
}