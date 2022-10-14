

import java.util.*;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i =0;i<n;i++){
            String first = Integer.toBinaryString(arr1[i]);
            if (first.length()<n){
                String empty="";
                for (int k=0;k<n-first.length();k++){
                    empty += "0";
                }
                first = empty+first;
            }
            String second = Integer.toBinaryString(arr2[i]);
            if (second.length()<n){
                String empty="";
                for (int k=0;k<n-second.length();k++){
                    empty += "0";
                }
                second = empty+second;
            }
            StringBuilder sb = new StringBuilder();
            for (int j=0; j <n;j++){
                if (first.charAt(j)=='1'||second.charAt(j)=='1'){
                    sb.append("#");
                }
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
