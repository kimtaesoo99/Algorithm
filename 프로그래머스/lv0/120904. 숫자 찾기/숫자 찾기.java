class Solution {
    public int solution(int num, int k) {
        String str = " " + num;
        int count = -1;
        for (int i = 1; i <str.length();i++){
            if (str.charAt(i)=='0'+k)return i;
        }
        return count;
    }
}