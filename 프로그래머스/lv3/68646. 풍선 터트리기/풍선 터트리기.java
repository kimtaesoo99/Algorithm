class Solution {
    public int solution(int[] a) {
        if (a.length == 1) {
            return 1;
        }

        int left = a[0];
        int right = a[a.length - 1];
        int result = 2;

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < left) {
                left = a[i];
                result++;
            }
            if (a[a.length - 1 - i] < right) {
                right = a[a.length - 1 - i];
                result++;
            }
            if (left == right) {
                result--;
                break;
            }
        }
        return result;
    }
}