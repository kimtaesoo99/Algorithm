
class Solution {
    public int[] solution(int n, int s) {
        if(n>s)return new int[]{-1};
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)arr[i] = s/n;
        int index = n-1;
        for(int i = 0; i < s%n;i++){
            arr[index]++;
            index--;
        }

        return arr;
    }
}