public class Solution {
    public long solution(long n) {
        long answer = -1;

        long re =(long)Math.sqrt(n);

        if (Math.pow(re,2)==n)answer = (long) Math.pow(re+1,2);


        return answer;
    }
}