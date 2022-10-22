


public class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] arr = s.split(" ");
        for (int i=0;i<arr.length;i++){
            max =Math.max(max,Integer.parseInt(arr[i]));
            min =Math.min(min,Integer.parseInt(arr[i]));
        }

        answer+=min+" "+max;
        return answer;
    }
}