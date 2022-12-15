class Solution {
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i<nums.length-2;i++){
            for (int j = i+1; j<nums.length-1; j++){
                for (int k = j+1; k<nums.length; k++){
                    if (isPrimeNumber(nums[i]+nums[j]+nums[k]))count++;
                }
            }
        }
        return count;
    }

    private boolean isPrimeNumber(int sum){
        System.out.println(sum);
        for (int i =2; i<sum; i++){
            if (sum%i==0)return false;
        }
        return true;
    }
}