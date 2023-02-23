class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int pos = 1;
        int staPos = 0;
        
        while(pos <= n){
            if(staPos<stations.length && pos >= stations[staPos] -w){
                pos = stations[staPos] + w +1;
                staPos++;
            }else {
                pos += 2*w +1;
                answer++;
            }
        }
        
 
        return answer;
    }
}