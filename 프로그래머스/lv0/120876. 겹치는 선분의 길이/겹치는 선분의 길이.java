class Solution {
    public int solution(int[][] lines) {
        boolean[] range = new boolean[201];
        int[][] overlap = new int[3][2];
        for (int i = 0; i< 3; i++){
            overlap[i][0] = Math.max(lines[i][0],lines[(i+1)%3][0]);
            overlap[i][1] = Math.min(lines[i][1],lines[(i+1)%3][1]);
        }
        for (int i = 0; i < 3; i++){
            if (overlap[i][1] - overlap[i][0] == 0)continue;
            for (int j = overlap[i][0]; j <= overlap[i][1]; j++){
                range[j+100] = true;
            }
        }
        int count = 0;
        for (int i = 1; i < range.length;i++){
            if (range[i] && range[i-1])count++;
        }
        return count;
    }
}