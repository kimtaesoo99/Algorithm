import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data)
                .filter(d -> d[getIndex(ext)] < val_ext)
                .sorted((s1, s2) -> s1[getIndex(sort_by)] - s2[getIndex(sort_by)])
                .toArray(int[][]::new);
    }

    private int getIndex(String ext) {
        if (ext.equals("code")) {
            return 0;
        }
        if (ext.equals("date")) {
            return 1;
        }
        if (ext.equals("maximum")) {
            return 2;
        }
        return 3;
    }
}