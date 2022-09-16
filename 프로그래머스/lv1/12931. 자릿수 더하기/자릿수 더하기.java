import java.util.Scanner;
public class Solution {
    public int solution(int n) {
        int answer = 0;

        String str  = n+"";
        for (int i =0; i<str.length(); i++){
            answer = answer+n%10;
            n=n/10;
        }


        return answer;
    }
}