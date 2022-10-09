

public class Solution {
    public int solution(int n) {
        String str ="";
        while (true){
            str+=n%3;
            if (n<3)break;
            n=n/3;
        }
        int answer=0;
        int count=0;
        for (int i=str.length()-1;i>=0;i--){
            answer+=(str.charAt(i)-'0')*Math.pow(3,count);
            count++;
        }
        return answer;
    }
}
