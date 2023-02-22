class Solution {
    public int solution(int n, int[][] results) {
        int[][] match = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            match[a][b] = 1;
            match[b][a] = -1;
        }
        
        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    if(match[i][j]==1 && match[j][k] ==1){
                        match[i][k] =1;
                        match[k][i] = -1;
                    }
                    if(match[i][j]==-1 && match[j][k] ==-1){
                        match[i][k] =-1;
                        match[k][i] = 1;
                    }
                }
            }
        }
        int answer=0;
        for(int i =1 ; i<=n; i++){
            int count = 0;
            for(int j = 1; j <=n;j++){
                if(match[i][j]!=0)count++;
            }
            if(count ==n-1)answer++;
        }
        
        return answer;
    }
}