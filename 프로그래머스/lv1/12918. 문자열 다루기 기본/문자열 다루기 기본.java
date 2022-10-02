public class Solution {
    public boolean solution(String s) {
        boolean result = false;
        if (s.length()==4||s.length()==6){
            for (int i=0;i<s.length();i++){
               if ('0'<=s.charAt(i)&&s.charAt(i)<='9'){
                   if (i==s.length()-1)result=true;
                }
               else break;
            }
        }

        return result;
    }
}