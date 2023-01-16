class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for (String s : my_string.split("")){
            if (!sb.toString().contains(s))sb.append(s);
        }
        return sb.toString();
    }
}