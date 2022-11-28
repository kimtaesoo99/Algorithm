import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        long zeroCount = Arrays.stream(lottos).filter(i ->i==0).count();
        List<Integer> list = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        int winingCount =0;
        for (int i=0;i<6;i++){
            if (list.contains(win_nums[i])){
                winingCount++;
            }
        }
        int[] answer = new int[2];
        answer[0] = (int)(7 - zeroCount-winingCount);
        answer[1] = (7 -winingCount);
         if (answer[0]==7)answer[0] = 6;
        if (answer[1]==7)answer[1] = 6;
        return answer;
    }
}