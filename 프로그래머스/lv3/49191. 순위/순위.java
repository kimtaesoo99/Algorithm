import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int[][] match = new int[n][n];
        for(int i = 0; i < results.length; i++){
            match[results[i][0]-1][results[i][1]-1] = 1;
            match[results[i][1]-1][results[i][0]-1] = -1;
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(match[i][k]==1 && match[k][j]==1){
                        match[i][j] = 1;
                        match[j][i] = -1;
                    }
                    if(match[i][k] ==-1 && match[k][j]==-1){
                        match[i][j] =-1;
                        match[j][i]= 1;
                    }
                }
            }
        }
        int answer = 0;
        for(int i =0;i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(match[i][j]!=0)count++;
            }
            if(count == n-1)answer++;
        }
        
        return answer;
    }
}