
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


class Solution {
    public String solution(String new_id) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            //처음 . 금지
            if (stack.isEmpty()&&c=='.')continue;
            // . 중복금지
            if (!stack.isEmpty()){
                if (Objects.equals(stack.peek(), String.valueOf(c)) && c =='.'){
                    continue;
                }
            }
            // 대문자 소문자로 변형
            if (Character.isUpperCase(c)){
                stack.push(String.valueOf(c).toLowerCase());
                continue;
            }
            // 소문지, 숫자,특수문자 허용
            if (correctChar(c))stack.push(String.valueOf(c));
        }
        if (stack.isEmpty())return "aaa";
        String result = stack.stream().limit(15).collect(Collectors.joining());
        if (result.endsWith(".")) result = result.substring(0,result.length()-1);
        if (result.length()==1)return result.repeat(3);
        if (result.length()==2)return result + result.charAt(1);


        return result;
    }

    boolean correctChar(char c){
        String form = "^[a-z0-9]*$";
        String check = "-._";
        if (Pattern.matches(form,String.valueOf(c)))return true;
        return check.contains(String.valueOf(c));
    }
}