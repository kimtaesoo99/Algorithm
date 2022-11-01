import java.util.Stack;
import java.util.stream.Collectors;
class Solution {
public static int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (!stack.empty()&&stack.peek().equals(s.charAt(i)))
                stack.pop();
            else stack.push(s.charAt(i));
        }

        String result = stack
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        if (result.equals(""))answer = 1;
        else answer=0;

        return answer;
    }
}