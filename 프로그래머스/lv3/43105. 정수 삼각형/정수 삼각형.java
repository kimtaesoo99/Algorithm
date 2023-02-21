import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][] result = new int[triangle.length][triangle.length];
        int max = 0;
        result[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j<=i; j++){
                if(j==0)result[i][j] = result[i-1][j] + triangle[i][j];
                else if(j==i)result[i][j] = result[i-1][j-1] + triangle[i][j];
                else result[i][j] = Math.max(result[i-1][j-1],result[i-1][j]) + triangle[i][j];
                max = Math.max(max, result[i][j]);
            }
        }

        return max;
    }
}