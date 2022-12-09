import java.util.Arrays;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (String  str : s2){
            if (Arrays.stream(s1).anyMatch(i -> i.equals(str)))answer++;
        }
        return answer;
    }
}