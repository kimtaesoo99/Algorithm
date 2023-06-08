class Solution {
    public String solution(String my_string, int[] index_list) {
        String result = "";
        for (int index : index_list) {
            result += my_string.charAt(index);
        }
        return result;
    }
}