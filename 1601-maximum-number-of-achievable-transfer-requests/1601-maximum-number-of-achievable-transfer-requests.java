class Solution {
    private int result = 0;
    private int[] building;

    public int maximumRequests(int n, int[][] requests) {
        building = new int[n];
        backTracking(requests, 0, n, 0);
        return result;
    }

    private void backTracking(int[][] requests, int index, int n, int count) {
        if (index == requests.length) {
            for (int i = 0; i < n; i++) {
                if (building[i] != 0) {
                    return;
                }
            }
            result = Math.max(result, count);
            return;
        }

        building[requests[index][0]]--;
        building[requests[index][1]]++;
        backTracking(requests, index + 1, n, count + 1);

        building[requests[index][0]]++;
        building[requests[index][1]]--;
        backTracking(requests, index + 1, n, count);
    }
}