public class Solution {
    public String solution(String s) {
        String a= "";
       if (s.length()%2==0){
           for (int i=s.length()/2-1; i<s.length()/2+1; i++){
               a+=s.charAt(i);
           }
       }
       else a+=s.charAt(s.length()/2);


        return  a;
    }
}