import java.util.Arrays;
import java.util.Collections;


public class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = n+"";
        Long[] arr = new Long[str.length()];
        for (int i=0;i<str.length();i++){
            arr[i] = n%10;
            n=n/10;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length(); i++){
            sb.append(arr[i]);
        }
        return Long.parseLong(sb+"");
    }
}