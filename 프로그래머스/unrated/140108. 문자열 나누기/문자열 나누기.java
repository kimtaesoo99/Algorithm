class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int sameCount = 1;
        int differentCount = 0;
        for (int i = 1; i < s.length(); i++){
            if (first == ' '){
                first = s.charAt(i);
                sameCount++;
                continue;
            }
            if (s.charAt(i)!=first)differentCount++;
            else sameCount++;
            if (sameCount == differentCount){
                first = ' ';
                sameCount = 0;
                differentCount = 0;
                answer++;
            }
        }
        if (first!=' ')answer++;
        return answer;
    }
}