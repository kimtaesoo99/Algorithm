import java.util.Arrays;
public class Solution {
    public static  int[] re;
    public int[] solution(int[] arr, int divisor) {
        int count =0;
        for (int i=0;i<arr.length; i++){
            if (arr[i]%divisor==0)count++;
        }

        if (count ==0){
            re = new int[1];
            re[0] = -1;
        }
        else {
            re = new int[count];
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % divisor == 0) {
                    re[k] = arr[i];
                    k++;
                }
            }
        }
        Arrays.sort(re);
        return  re;

    }
}