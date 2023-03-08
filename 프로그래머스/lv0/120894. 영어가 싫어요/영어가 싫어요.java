class Solution {
    public long solution(String numbers) {
        String result = numbers;
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] count = {"0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i <= 9; i++){
            result = result.replace(number[i],count[i]);
        }

        return Long.parseLong(result);
    }
}