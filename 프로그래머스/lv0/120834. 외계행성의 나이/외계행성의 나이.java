class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < String.valueOf(age).length(); i++) {
            sb.append((char)(Integer.parseInt(String.valueOf(age).charAt(i)+"")+'a'));
        }
        return sb.toString();
    }
}