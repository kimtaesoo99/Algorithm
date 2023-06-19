import java.util.*;

class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < myString.length(); i++) {
            char now = myString.charAt(i);
            if(now - 'l' <= 0) {
                sb.append("l");
            }else sb.append(now);
        }
        return sb.toString();
    }
}