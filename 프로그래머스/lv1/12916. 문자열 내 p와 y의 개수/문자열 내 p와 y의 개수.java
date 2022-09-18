public class Solution {
    boolean solution(String str) {
        boolean answer = false;
        int scount =0;
        int pcount =0;

        for (int i =0;i<str.length();i++){
            if (str.charAt(i)=='y'||str.charAt(i)=='Y') scount++;
            else if ( str.charAt(i)=='p'||str.charAt(i)=='P') pcount++;
        }
        if (scount==pcount)answer=true;

        return answer;
    }
}