import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int tryCount = 0;
        while (!s.equals("1")){
            int preSize = s.length();
            s =s.replaceAll("0","");
            zeroCount += (preSize - s.length());
            s = Integer.toBinaryString(s.length());
            tryCount++;
        }
        return new int[]{tryCount,zeroCount};
    }
}