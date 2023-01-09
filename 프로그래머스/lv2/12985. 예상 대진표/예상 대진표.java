class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        while (a!=b){
            a = (int) Math.ceil(a/2.);
            b = (int) Math.ceil(b/2.);
            answer++;
        }
        return answer;
    }
}