


public class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] arr = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] str = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int result =0;

        for (int i =0; i<a-1;i++){
            result+=arr[i];
        }
        result+=b;

        result = (result-1)%7;

        return answer+str[result];
    }
}