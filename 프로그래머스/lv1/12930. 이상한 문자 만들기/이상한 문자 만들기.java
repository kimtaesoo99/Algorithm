

public class Solution {
    public String solution(String s) {
        String answer ="";
        String str ="";
        int index =0;
        for (int i=0;i<s.length();i++){
            if (index%2==0){
                str+=s.charAt(i);
                str = str.toUpperCase();
                answer+=str;
                str = "";
            }
            else {
                str+=s.charAt(i);
                str = str.toLowerCase();
                answer+=str;
                str="";
            }
            if (s.charAt(i)==' '){
                index=-1;
            }

            index++;
        }

        return answer;
    }
}