class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < number.length() - k; i++){
            int max = 0;

            for (int j = index; j <= i + k; j++){
                int num = number.charAt(j) -'0';
                if (max < num){
                    max = num;
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}