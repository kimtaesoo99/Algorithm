public class Solution {
    public int solution(int num) {
        int answer = 0;

        for (int i=1; i<num; i++){
            if (num%i==1){
                answer=i;
                break;
            }
        }
        return answer;
    }
}