import java.util.*;
class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        findTargetNumber(0,0,numbers,target);
        return count;
    }

    
    public void findTargetNumber(int index, int sum,int[] numbers, int target){
        if(index == numbers.length){
            if(target==sum)count++;
            return;
        }
        findTargetNumber(index+1,sum+numbers[index],numbers,target);
        findTargetNumber(index+1,sum-numbers[index],numbers,target);
    }
}