


public class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;
        for (int i=0; i< sizes.length;i++){
            int max = Math.max(sizes[i][0],sizes[i][1]);
            int min = Math.min(sizes[i][0],sizes[i][1]);
            w = Math.max(max,w);
            h = Math.max(min,h);
        }
        answer = w*h;
        return answer;
    }
}