


import java.util.Arrays;
public class Solution {
    public int solution(int[] a, int[ ]b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int count=0;
        int sum=0;
        int k=0;
        int j = a.length-1;
        while (count<a.length){
            count++;
            sum+= a[k++]*b[j--];
        }


        return sum;
    }
}