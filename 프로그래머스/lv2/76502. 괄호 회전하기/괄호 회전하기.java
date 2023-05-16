import java.util.Stack;

class Solution {
    static int answer;

    public int solution(String s) {
        combination(s);
        return answer;
    }

    private void combination(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(0);
            s = s.substring(1) + c;
            if (isCollect(s)) {
                answer++;
            }
        }
    }

    private boolean isCollect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '[' || now == '{' || now == '(') {
                stack.push(now);
            } else if (!stack.isEmpty()) {
                if (stack.peek() == '{' && now == '}') {
                    stack.pop();
                    continue;
                }
                if (stack.peek() == '[' && now == ']') {
                    stack.pop();
                    continue;
                }
                if (stack.peek() == '(' && now == ')') {
                    stack.pop();
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}