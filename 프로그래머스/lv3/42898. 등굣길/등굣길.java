class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] result = new int[n][m];
        boolean[][] water = new boolean[n][m]; 
        for(int i = 0 ; i < puddles.length; i++){
            int y = puddles[i][0];
            int x = puddles[i][1];
            water[x-1][y-1] = true;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(water[i][j])continue;
                if(j==0 && i==0) result[i][j] = 1;
                else if(i==0)result[i][j] = result[i][j-1];
                else if(j==0)result[i][j] = result[i-1][j];
                else{
                    result[i][j] = (result[i-1][j] + result[i][j-1])%1000000007;
                }
            }
        }
        return result[n-1][m-1];
    }
}