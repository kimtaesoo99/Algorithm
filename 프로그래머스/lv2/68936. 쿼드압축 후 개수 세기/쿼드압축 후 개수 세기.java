class Solution {
    static int zero;
    static int one;

    public int[] solution(int[][] arr) {
        compression(arr.length, arr, 0, 0);
        return new int[]{zero, one};
    }

    private void compression(int length, int[][] arr, int y, int x) {
        if (isSameArea(length, arr, y, x)) {
            if (arr[y][x] == 1) {
                one++;
                return;
            }
            zero++;
            return;
        }
        int halfLength = length / 2;
        compression(halfLength, arr, y, x);
        compression(halfLength, arr, y + halfLength, x);
        compression(halfLength, arr, y, x + halfLength);
        compression(halfLength, arr, y + halfLength, x + halfLength);
    }

    private boolean isSameArea(int length, int[][] arr, int y, int x) {
        int first = arr[y][x];
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}