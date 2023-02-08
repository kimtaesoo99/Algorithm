class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; ; i++){
            if (6*i%n==0){
                count = i;
                break;
            }
        }
        return count;
    }
}
