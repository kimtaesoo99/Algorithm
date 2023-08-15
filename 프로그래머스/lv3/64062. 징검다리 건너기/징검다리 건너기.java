class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canMove(mid, k, stones)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean canMove(int people, int k, int[] stones) {
        int count = 0;
        for (int stone : stones) {
            if (stone - people < 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                return false;
            }
        }
        return true;
    }
}