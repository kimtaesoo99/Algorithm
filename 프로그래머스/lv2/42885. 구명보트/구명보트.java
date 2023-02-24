import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int end = people.length-1;
        int answer = 0;
        for(int i = 0; i<people.length/2; i++){
            if(i>end)break;
            if(people[i] + people[end]<=limit){
                end--;
                answer++;
            }else{
                i--;
                end--;
                answer++;
            }
        }
        return answer;
    }
}