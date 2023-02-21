class Solution {
    public int solution(int[] money) {
        int n = money.length;
       
        int[] firstStart = new int[n-1];
        int[] secondStart = new int[n];
        
        firstStart[0] = money[0];
        firstStart[1] = money[0];
        
        secondStart[0] = 0;
        secondStart[1] = money[1];
        
        for(int i = 2; i < n; i++){
            secondStart[i] = Math.max(secondStart[i-2] + money[i], secondStart[i-1]);
            if(i==n-1)break;
            firstStart[i] = Math.max(firstStart[i-2] + money[i], firstStart[i-1]);
        }
        return Math.max(firstStart[n-2],secondStart[n-1]);
    }
}