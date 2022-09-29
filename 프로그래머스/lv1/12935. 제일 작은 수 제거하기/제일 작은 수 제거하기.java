
public class Solution {
    public static int[] arr2;
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length;i++){
            if (arr[i]<min)min = arr[i];
        }
        int count =0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==min)count++;
        }
        int k=0;
        arr2 = new int[arr.length-count];
        if (arr.length-count==0){
            int[] arr3 = new int[1];
            arr3[0] = -1;
            return arr3;
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == min) continue;
                else arr2[k++] = arr[i];
            }
        }
        return arr2;
    }
}