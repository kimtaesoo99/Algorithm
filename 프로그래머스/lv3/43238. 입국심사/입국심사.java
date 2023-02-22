import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long min = 0;
        Arrays.sort(times);
        long max = times[times.length-1] * (long) n;
        long result = 0;
        while(min<=max){
            long mid = (min+max)/2;
            long sum = 0;
            for(int i = 0; i <times.length; i++){
                sum +=mid/times[i];
            }
            if(sum<n){
                min = mid+1;
            }else {
                max = mid-1;
                result = mid;
            }
        }
        return result;
    }
}