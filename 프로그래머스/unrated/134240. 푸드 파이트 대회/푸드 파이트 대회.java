class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< food.length; i++){
            if (food[i]>=2)sb.append(String.valueOf(i).repeat(food[i]/2));
        }
        String left = sb.toString();
        return left + "0" + sb.reverse();
    }
}