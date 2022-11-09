class Solution {
 public static int solution(int[] arr) {
        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = findMinMultiply(min,arr[i]);
        }

        return min;
    }

    public static int findMinMultiply(int x, int y){
        int count=0;
        for (int i=1;i<= (x<y?x:y); i++){
            if (x%i==0&&y%i==0)count = i;
        }
        return x*y/count;
    }
}
