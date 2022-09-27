
public class Solution {
    public String solution(String phone_number) {
        String str ="";
        int size = phone_number.length();
        for (int i=0; i<size; i++){
            if (i>size-5)str=str+phone_number.charAt(i);
            else str = str+"*";
        }


        return str;
    }
}