

public class Solution {
    public int solution(int n) {

        int sum=0;
        int count =0;
        for (int i = 1; i<=n;i++){
            for (int j =i;j<=n;j++){
                sum+=j;
                if(sum==n){
                    count++;
                    break;
                }
                if (sum>n)break;
            }
            sum = 0;
        }

        return count;
    }
}